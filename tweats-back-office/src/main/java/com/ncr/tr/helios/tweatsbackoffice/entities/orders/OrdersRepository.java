package com.ncr.tr.helios.tweatsbackoffice.entities.orders;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrdersRepository extends MongoRepository<Orders, String > {


    // fav order lookup, check to see if the unicode they sent matches the one already initialized in db

    // if its there, create the order, we send a create ResponseEntity<Order> 201 status


}
