package ru.ncd;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;


@WebMvcTest
@RunWith(SpringRunner.class )
public class SwaggerControllerTest {

    @Autowired
    MockMvc mockMvc;


    MatrixInitializer mi = mock(MatrixInitializer.class);

    GraphInitializer gi = mock(GraphInitializer.class);

    DataInitializer di = mock(DataInitializer.class);


    @InjectMocks
    SwaggerController swaggerController;

    @Test
    public void postFileTest() throws FileNotFoundException, Exception {

        Mockito.doNothing().when(mi).matrixInitialize(any(), any());
        Mockito.doNothing().when(gi).graphInitialize(any(), any());
        Mockito.doNothing().when(di).dataInitialize(any(), any(), any());
        MockMultipartFile file = new MockMultipartFile("file", "orig", MediaType.MULTIPART_FORM_DATA_VALUE, "string".getBytes());
        swaggerController.postFile(file);
        RequestBuilder request = MockMvcRequestBuilders.multipart("/api/v1/file").file(file).contentType(MediaType.MULTIPART_FORM_DATA_VALUE);
        mockMvc.perform(request).andExpect(status().isOk());
    }

}
