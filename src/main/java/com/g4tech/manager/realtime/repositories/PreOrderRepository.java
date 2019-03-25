package com.g4tech.manager.realtime.repositories;

import com.g4tech.manager.realtime.models.PreOrder;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PreOrderRepository extends MongoRepository<PreOrder, String> {
    PreOrder findById (ObjectId id);
}
