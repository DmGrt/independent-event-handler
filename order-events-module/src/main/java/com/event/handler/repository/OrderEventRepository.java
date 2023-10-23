package com.event.handler.repository;

import com.event.handler.model.OrderEvent;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderEventRepository extends MongoRepository<OrderEvent, UUID> {}
