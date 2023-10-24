package com.event.handler.repository;

import com.event.handler.model.CustomerEvent;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerEventRepository extends MongoRepository<CustomerEvent, UUID> {}
