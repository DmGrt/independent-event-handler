package com.event.handler.repository;

import com.event.handler.model.Event;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, UUID> {
  Event findByEventType(String eventType);
}
