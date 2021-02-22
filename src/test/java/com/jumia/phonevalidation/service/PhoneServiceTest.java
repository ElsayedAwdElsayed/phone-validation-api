package com.jumia.phonevalidation.service;

import com.jumia.phonevalidation.repository.CustomerRepository;
import com.jumia.phonevalidation.util.PhoneTestSetup;
import com.jumia.phonevalidation.validator.PhoneValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PhoneServiceTest extends PhoneTestSetup {

    @InjectMocks
    private PhoneService phoneService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private PhoneValidator phoneValidator;

    @BeforeEach
    public void setUp() {
            super.setUp();
    }

    /**
     * There is missing case here
     */
    @Test
    public void getAllValidPhoneNumbers() {
        when(customerRepository.findAll()).thenReturn(customerList);
        when(phoneValidator.validate(anyString())).thenReturn(true);
        Assertions.assertEquals(phoneService.getAllValidPhoneNumbers().size(),2);
    }


}
