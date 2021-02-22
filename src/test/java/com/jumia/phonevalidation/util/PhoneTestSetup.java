package com.jumia.phonevalidation.util;

import com.jumia.phonevalidation.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class PhoneTestSetup extends AbstractTest{

    protected List<Customer> customerList;

    public void setUp() {
        customerList=new ArrayList<>();
        Customer firstCustomer=new Customer();
        firstCustomer.setId(1);
        firstCustomer.setName("firstName");
        firstCustomer.setPhone("(258) 042423566");

        Customer secondCustomer=new Customer();
        secondCustomer.setId(2);
        secondCustomer.setName("secondName");
        secondCustomer.setPhone("(256) 7734127498");
        customerList.add(firstCustomer);
        customerList.add(secondCustomer);
    }



}
