package com.jumia.phonevalidation.service;

import com.jumia.phonevalidation.entity.Customer;
import com.jumia.phonevalidation.repository.CustomerRepository;
import com.jumia.phonevalidation.validator.PhoneValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PhoneValidator phoneValidator;

    public List<String> getAllValidPhoneNumbers()
    {
        List<Customer>   customerList=customerRepository.findAll();
        return customerList.stream().map(customer -> customer.getPhone()).filter(
                phoneNumber->phoneValidator.validate(phoneNumber)).collect(Collectors.toList());
    }


}
