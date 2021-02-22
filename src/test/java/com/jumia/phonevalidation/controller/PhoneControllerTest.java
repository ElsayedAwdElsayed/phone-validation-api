package com.jumia.phonevalidation.controller;

import com.jumia.phonevalidation.service.PhoneService;
import com.jumia.phonevalidation.util.AbstractTest;
import com.jumia.phonevalidation.util.PhoneTestSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PhoneControllerTest extends AbstractTest {

    private MockMvc mvc;

    @InjectMocks
    private PhoneController phoneController;

    @Mock
    private PhoneService phoneService;

    @BeforeEach
   public void setUp() {
        this.mvc = MockMvcBuilders.standaloneSetup(phoneController).build();
    }

    @Test
    public void test_getAllValidPhoneNumbers() throws Exception {
        List<String> phoneMockList=new ArrayList<>();
        phoneMockList.add("(258) 042423566");
        phoneMockList.add("(258) 823747618");
        when(phoneService.getAllValidPhoneNumbers()).thenReturn(phoneMockList);
        MvcResult mvcResult=mvc.perform(get("/api/phone/list").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
        String contentAsString=mvcResult.getResponse().getContentAsString();
        List<String> phoneList=mapFromJson(contentAsString,List.class);
        Assertions.assertEquals(phoneList.size(),2);
    }


}