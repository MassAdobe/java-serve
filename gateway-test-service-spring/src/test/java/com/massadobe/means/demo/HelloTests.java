package com.massadobe.means.demo;

import com.google.common.base.Strings;
import com.massadobe.means.demo.constants.ConstantsConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MassadobeDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Before
    public void setUp() throws Exception {
        String url = String.format("http://localhost:%d/", port);
        System.out.println(String.format("port is : [%d]", port));
    }

    @Test
    public void Master() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20; i++) {
            int x = i;
            executor.execute(() -> {
                String header = Strings.lenientFormat("{\"guid\" : %s,\"sysid\" : %s}", String.valueOf(x), String.valueOf(x));
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.add("user", header);
                httpHeaders.setContentType(MediaType.valueOf("application/json"));
                HttpEntity<String> str = new HttpEntity<>("", httpHeaders);
                ResponseEntity<String> result = this.testRestTemplate.exchange("http://localhost:" + port + ConstantsConfig.APPLICATION_NAME + "/hello/printSth", HttpMethod.GET, str, String.class);
                System.out.println(Strings.lenientFormat("REQUEST: %s, COUNTING: %d, ANS: %s", header, x, result.getBody()));
            });
        }
        Thread.sleep(100000);
    }

}
