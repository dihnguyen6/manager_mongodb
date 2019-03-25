package com.g4tech.manager.realtime.repositories;

import com.g4tech.manager.realtime.models.Bill;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "/bills", path = "/bills")
public interface BillRepository extends MongoRepository<Bill, String> {
    Bill findById (ObjectId id);
}
