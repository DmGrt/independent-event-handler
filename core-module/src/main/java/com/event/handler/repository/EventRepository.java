package com.event.handler.repository;

import com.event.handler.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, Long> {
  Event findByEventType(String eventType);
}
