package ru.ncd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.ncd.objectInitializers.GraphInitializer;
import ru.ncd.objectInitializers.MatrixInitializer;
import ru.ncd.objects.Graph;
import ru.ncd.objects.Matrix;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@RunWith(SpringRunner.class)
public class SwaggerControllerUnitTest {

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


    @Test
    public void postFileTest() throws Exception {
       //MockitoAnnotations.initMocks(swaggerController);
        Mockito.doNothing().when(mi).matrixInitialize(any(), any());
        Mockito.doNothing().when(gi).graphInitialize(any(), any());
        Mockito.doNothing().when(di).dataInitialize(any(), any(), any());
        Mockito.doNothing().when(dataDao).addToDataBase(data, matrix, graph);
      //  FileInputStream fis = new FileInputStream("./src/test/resources/input.txt");
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "input.txt", MediaType.MULTIPART_FORM_DATA_VALUE, "string".getBytes());
        //swaggerController.postFile(mockMultipartFile);
        RequestBuilder request = MockMvcRequestBuilders.multipart("/api/v1/file").file(mockMultipartFile).contentType(MediaType.MULTIPART_FORM_DATA_VALUE);
        mockMvc.perform(request).andExpect(status().isOk());
    }

}
