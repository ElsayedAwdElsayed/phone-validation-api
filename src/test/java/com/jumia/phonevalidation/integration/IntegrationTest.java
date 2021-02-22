package com.jumia.phonevalidation.integration;

import com.jumia.phonevalidation.controller.PhoneController;
import com.jumia.phonevalidation.util.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
public class IntegrationTest extends AbstractTest {

    MockMvc mockMvc;

    @Autowired
    private PhoneController phoneController;

    @BeforeEach
    public void setUp()
    {
        this.mockMvc = standaloneSetup(phoneController).build();
    }

    @Test
    public void test_getAllValidPhoneNumbers() throws Exception {
        MvcResult mvcResult=mockMvc.perform(get("/api/phone/list").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
        String contentAsString=mvcResult.getResponse().getContentAsString();
        List<String> phoneList=mapFromJson(contentAsString,List.class);
        assertThat(phoneList.size(),greaterThanOrEqualTo(1));
    }



}
