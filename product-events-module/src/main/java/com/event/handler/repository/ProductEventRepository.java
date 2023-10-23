package com.event.handler.repository;

import com.event.handler.model.ProductEvent;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEventRepository extends MongoRepository<ProductEvent, UUID> {}
