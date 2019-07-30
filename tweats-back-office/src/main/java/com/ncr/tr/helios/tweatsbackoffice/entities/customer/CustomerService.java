package com.ncr.tr.helios.tweatsbackoffice.entities.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;



public interface CustomerService {

    CustomerInfo getCustomerByHandle(String twitterHandle);
}
