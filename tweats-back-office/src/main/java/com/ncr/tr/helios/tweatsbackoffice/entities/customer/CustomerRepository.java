package com.ncr.tr.helios.tweatsbackoffice.entities.customer;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerInfo, String> {
}
