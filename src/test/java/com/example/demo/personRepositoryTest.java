package com.example.demo;

import com.example.demo.Dao.personRepo;
import com.example.demo.Entities.person;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

@RunWith(SpringRunner.class)

@SpringBootTest(
        classes = DemoApplication.class


)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class personRepositoryTest {
    @Autowired
    MockMvc mockMvc;


    @Test
    public void contextLoads() throws Exception {


        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/allPersons").accept(MediaType.APPLICATION_JSON)
        ).andReturn();


        System.out.println(mvcResult.getResponse());


    }

}
