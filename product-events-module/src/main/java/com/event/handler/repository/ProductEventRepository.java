package com.event.handler.repository;

import com.event.handler.model.ProductEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductEventRepository extends MongoRepository<ProductEvent, UUID> {}
