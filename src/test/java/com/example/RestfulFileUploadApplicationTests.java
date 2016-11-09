package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class RestfulFileUploadApplicationTests {


    private final String IMAGE_NAME = "test_image.jpg";

    private final String endPoint = "/rest/upload";

    private final String FILE_EXTENSION = "jpg";

    @Value("${file.repository}")
    private String fileStorageLocation;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @Before
    public void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @After
    public void tearUp() {

        FileSystemUtils.deleteRecursively(new File(fileStorageLocation));
    }

    @Test
    public void fileUploadTest() throws Exception {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL fileUrl = classloader.getResource(IMAGE_NAME);
        File file = new File(URLDecoder.decode(fileUrl.getFile(), "utf-8"));
        InputStream inputStream = new FileInputStream(file);
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", IMAGE_NAME, FILE_EXTENSION, inputStream);
        mockMvc.perform(MockMvcRequestBuilders.fileUpload(endPoint).file(mockMultipartFile))
                .andExpect(status().isCreated());

    }
}
