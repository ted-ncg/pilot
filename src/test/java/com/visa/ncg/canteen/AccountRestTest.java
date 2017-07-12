package com.visa.ncg.canteen;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AccountRestTest {

  @Autowired
  private MappingJackson2HttpMessageConverter springMvcJacksonConverter;

  @Autowired
  private MockMvc mockMvc;

  private ObjectMapper objectMapper;

  @Before
  public void before() {
    objectMapper = springMvcJacksonConverter.getObjectMapper();
  }

  @Test
  public void postCreatesNewAccount() throws Exception {
    mockMvc.perform(post("/accounts"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("{\"id\":123,\"balance\":0}")
        );
    mockMvc.perform(get("/accounts/123"))
        .andExpect(status().isOk())
        .andExpect(content().string("{\"id\":123,\"balance\":0}")
        );
  }

  @Test
  public void postCreatesNewAccountJson() throws Exception {
    mockMvc.perform(post("/accounts"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value("123"))
        .andExpect(jsonPath("$.balance").value("0"));

    mockMvc.perform(get("/accounts/123"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value("123"))
        .andExpect(jsonPath("$.balance").value("0"));
  }

}
