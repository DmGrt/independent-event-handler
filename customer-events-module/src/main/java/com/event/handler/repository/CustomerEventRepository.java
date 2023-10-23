package com.event.handler.repository;

import com.event.handler.model.CustomerEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerEventRepository extends MongoRepository<CustomerEvent, UUID> {}
