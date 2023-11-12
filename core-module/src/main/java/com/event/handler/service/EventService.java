package com.event.handler.service;

import com.event.handler.model.Event;
import com.event.handler.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventService {

  private final EventRepository eventRepository;

  // Event handling methods
  public void processEvent(final Event event) {
    validateEvent(event);
    transformEvent(event);
    storeEvent(event);
  }

  public void validateEvent(final Event event) {
    if (event == null) {
      throw new IllegalArgumentException("Event must not be null");
    }

    if (event.getType() == null || event.getType().trim().isEmpty()) {
      throw new IllegalArgumentException("Event type must be specified");
    }

    if (StringUtils.isNoneEmpty(event.getPayload())) {
      throw new IllegalArgumentException("Event value must be a positive number");
    }
  }

  public void transformEvent(final Event event) {
    if (event != null && event.getType() != null) {
      event.setType(event.getType().toUpperCase());
    }
  }

  public void storeEvent(final Event event) {
    eventRepository.save(event);
  }

  public Event getEventById(final Long eventId) {
    return eventRepository.findById(eventId).orElseThrow();
  }
}
