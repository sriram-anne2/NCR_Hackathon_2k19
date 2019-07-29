package com.ncr.tr.helios.tweatsbackoffice.customer;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {



    Customer findCustomerByTwitterHandle(String twitterHandle);

}
