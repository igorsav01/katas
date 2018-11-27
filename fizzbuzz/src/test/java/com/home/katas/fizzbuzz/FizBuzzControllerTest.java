package com.home.katas.fizzbuzz;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class FizBuzzControllerTest {

    @Mock
    private FizzBuzz fizzBuzz;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        FizzBuzzController fizzBuzzController = new FizzBuzzController(fizzBuzz);
        mockMvc = MockMvcBuilders.standaloneSetup(fizzBuzzController).build();

    }

    @Test
    public void getNumberSequence_returnsStringOfNumbers() throws Exception{
        when(fizzBuzz.print(1,9)).thenReturn("1,2,fizz");

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/sequence/1/9")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result",  equalTo("1,2,fizz")));
    }

    @Test
    public void postNumberSequence_returnsStringOfNumbers() throws Exception{
        String incomingJson = "{\"from\": \"1\", \"to\": \"9\"}";
        when(fizzBuzz.print(1,9)).thenReturn("1,2,fizz");

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/sequence/")
                .content(incomingJson)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result",  equalTo("1,2,fizz")));
    }


}
