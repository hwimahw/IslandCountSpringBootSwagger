package ru.ncd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.FileInputStream;
import static junit.framework.TestCase.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SwaggerControllerIntegrationTest  {


    @Autowired
    private SwaggerController swaggerController;

    @Test
    public void postFile() throws Exception {
        FileInputStream fis = new FileInputStream("./src/test/resources/input.txt");
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "input.txt", MediaType.MULTIPART_FORM_DATA_VALUE, fis);
        Data data =  swaggerController.postFile(mockMultipartFile);
        assertEquals("result is not right", 1, data.result);

    }

}
