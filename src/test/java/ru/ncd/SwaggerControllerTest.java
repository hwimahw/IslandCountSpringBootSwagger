package ru.ncd;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.io.FileInputStream;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@RunWith(SpringRunner.class)
public class SwaggerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MatrixInitializer mi;

    @MockBean
    GraphInitializer gi;

    @MockBean
    DataInitializer di;

    Data data = mock(Data.class);

    Matrix matrix = mock(Matrix.class);

    Graph graph = mock(Graph.class);

    @MockBean
    DataDAO dataDao;


  //  @InjectMocks
  //  SwaggerController swaggerController;

    @Test
    public void postFileTest() throws Exception {
       //MockitoAnnotations.initMocks(swaggerController);
        Mockito.doNothing().when(mi).matrixInitialize(any(), any());
        Mockito.doNothing().when(gi).graphInitialize(any(), any());
        Mockito.doNothing().when(di).dataInitialize(any(), any(), any());
        Mockito.doNothing().when(dataDao).addToDataBase(data, matrix, graph);
        FileInputStream fis = new FileInputStream("./src/test/resources/input.txt");
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "input.txt", MediaType.MULTIPART_FORM_DATA_VALUE, fis);
        //swaggerController.postFile(mockMultipartFile);
        RequestBuilder request = MockMvcRequestBuilders.multipart("/api/v1/file").file(mockMultipartFile).contentType(MediaType.MULTIPART_FORM_DATA_VALUE);
        mockMvc.perform(request).andExpect(status().isOk());
    }

}
