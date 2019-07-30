package com.ncr.tr.helios.tweatsbackoffice.entities.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired private CustomerRepository customerRepository;


    @Override
    public CustomerInfo getCustomerByHandle(String twitterHandle) {
        return customerRepository.findByCustomerTwitterHandle(twitterHandle);
    }
}
