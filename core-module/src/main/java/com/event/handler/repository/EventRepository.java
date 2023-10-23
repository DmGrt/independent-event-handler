package com.event.handler.repository;

import com.event.handler.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventRepository extends MongoRepository<Event, UUID> {}
