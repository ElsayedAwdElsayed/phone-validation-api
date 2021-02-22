package com.jumia.phonevalidation.validator;

import com.jumia.phonevalidation.config.ConfigUtility;
import org.junit.jupiter.api.Assertions;
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
public class PhoneValidatorTest {

    @InjectMocks
    private PhoneValidator phoneValidator;

    @Mock
    private ConfigUtility configUtility;

    @Test
    public void test_validateEmptyPhoneNumber() {
        Assertions.assertEquals(phoneValidator.validate(""),false);
    }

    @Test
    public void test_validateEmptyCountryCode() {
        Assertions.assertEquals(phoneValidator.validate(" )654642448"),false);
    }

    @Test
    public void test_validateMissingRegularExpression(){
        when(configUtility.getProperty("212")).thenReturn("");
        Assertions.assertEquals(phoneValidator.validate("(212) 654642448"),false);
    }

    @Test
    public void test_validPhoneNumberByMatchingRegularExpression()
    {
        when(configUtility.getProperty("212")).thenReturn("\\(212\\)\\ ?[5-9]\\d{8}$");
        Assertions.assertEquals(phoneValidator.validate("(212) 698054317"),true);
    }

    @Test
    public void test_inValidPhoneNumberByMatchingRegularExpression()
    {
        when(configUtility.getProperty("212")).thenReturn("\\(212\\)\\ ?[5-9]\\d{8}$");
        Assertions.assertEquals(phoneValidator.validate("(212) 6546545369"),false);
    }


}