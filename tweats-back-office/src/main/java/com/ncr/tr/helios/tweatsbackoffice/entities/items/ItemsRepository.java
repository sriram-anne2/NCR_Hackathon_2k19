package com.ncr.tr.helios.tweatsbackoffice.entities.items;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemsRepository extends MongoRepository<Items, String> {
}
