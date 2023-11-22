package com.event.handler.repository;

import com.event.handler.model.Event;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, Long> {
  List<Event> findAllByTimestampAfter(LocalDateTime localDateTime);
}
