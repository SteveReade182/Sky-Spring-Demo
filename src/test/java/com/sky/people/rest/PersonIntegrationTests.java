package com.sky.people.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sky.people.dto.PersonDTO;
import com.sky.people.dto.PersonReqDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // loads the app context with all your beans
@AutoConfigureMockMvc // sets up the testing library
public class PersonIntegrationTests {

    @Autowired // tells Spring to inject the mvc object into my test class.
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;
    @Test
    void testCreate() throws Exception{
        // body, method, url, content-type
        PersonReqDTO newPerson = new PersonReqDTO("Steve", 32, "Coder","NI Unavailable");

        String newPersonAsJSON = this.mapper.writeValueAsString(newPerson);

        RequestBuilder req = MockMvcRequestBuilders.post("/create").content(newPersonAsJSON).contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isCreated();

        PersonDTO created = new PersonDTO("Steve",32,"Coder");

        ResultMatcher checkBody = MockMvcResultMatchers.content().json(this.mapper.writeValueAsString(created));

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

    }



}
