package ru.ncd;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;


@WebMvcTest
@RunWith(MockitoJUnitRunner.class)
public class SwaggerControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Mock
    Graph graph;

    @Mock
    Data data;

    @Mock
    Matrix matrix;

    @Mock
    InputStream fileStream;

    @Mock
    MatrixInitializer mi;

    @Mock
    GraphInitializer gi;

    @Mock
    DataInitializer di;


    @Test
    public void postFileTest() throws FileNotFoundException, Exception {

        Mockito.doNothing().when(mi).matrixInitialize(fileStream, matrix);
        Mockito.doNothing().when(gi).graphInitialize(graph, matrix);
        Mockito.doNothing().when(di).dataInitialize(data, matrix, graph);
        mi.matrixInitialize(fileStream, matrix);
        gi.graphInitialize(graph, matrix);
        di.dataInitialize(data, matrix, graph);
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file","input.txt", "text/plain", "test data".getBytes());
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.fileUpload("/api/v1/file").file(mockMultipartFile).contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(MockMvcResultMatchers.status().is(200)).andReturn();
        Assert.assertEquals(200, result.getResponse().getStatus());
    }

}
