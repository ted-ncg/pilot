package com.visa.ncg.canteen.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.visa.ncg.canteen.domain.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    MockHttpServletResponse response = mockMvc.perform(post("/accounts"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").isNumber())
        .andExpect(jsonPath("$.balance").value("0"))
        .andReturn().getResponse();
    Account account = objectMapper.readValue(response.getContentAsString(), Account.class);

    mockMvc.perform(get("/accounts/{id}", account.getId()))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(account.getId()))
        .andExpect(jsonPath("$.balance").value("0"));
  }

}
