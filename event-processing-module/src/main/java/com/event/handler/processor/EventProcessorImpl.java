package com.event.handler.processor;

import com.event.handler.model.Event;
import com.event.handler.repository.EventRepository;
import jakarta.transaction.Transactional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
public class EventProcessorImpl implements EventProcessor {
  private final EventRepository eventRepository;

  @Override
  public void processEvent(Event event) {
    event.setId(UUID.randomUUID());
    Event savedEvent = eventRepository.save(event);
    log.info("Event with id: {} already was processed successfully.", savedEvent.getId());
  }
}
