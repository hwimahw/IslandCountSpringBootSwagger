package ru.ncd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import java.io.FileInputStream;
import static junit.framework.TestCase.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@RunWith(SpringRunner.class)
public class SwaggerControllerIntegrationTest  {


    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void postFile() throws Exception {
        FileInputStream fis = new FileInputStream("./src/test/resources/input.txt");
       /* ByteArrayResource resource = new ByteArrayResource(file.getBytes()){
        @Override
        public String getFilename(){
            return "input.txt";
        }
    };*/
        MultipartFile file = new MockMultipartFile("file", "input.txt", MediaType.MULTIPART_FORM_DATA_VALUE, fis);
        ClassPathResource resource  = new ClassPathResource("input.txt");
        MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<>();
        parameters.add("file", resource);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, Object>> requestEntity =
                new HttpEntity<>(parameters, headers);
      //  Data data = restTemplate.postForObject("/api/v1/file", requestEntity, Data.class);
        Data data = restTemplate.exchange("/api/v1/file", HttpMethod.POST,requestEntity, Data.class).getBody();
        String str = data.matrix;
        assertEquals("result is not right", 1, data.getResult());

    }

}