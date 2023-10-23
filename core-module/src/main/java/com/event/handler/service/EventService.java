package com.event.handler.service;

import com.event.handler.model.Event;
import com.event.handler.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventService {

  private final EventRepository eventRepository;

  // Event handling methods
  public void processEvent(final Event event) {
    // Implement domain-independent processing logic.
  }

  public void validateEvent(final Event event) {
    // Implement validation logic for the event.
  }

  public void transformEvent(final Event event) {
    // Implement transformation logic for the event if needed.
  }

  public void storeEvent(final Event event) {
    // Implement logic to store the event in a database or message queue.
  }

  public Event getEventById(final UUID eventId) {
    return eventRepository.findById(eventId).orElseThrow();
  }
}
