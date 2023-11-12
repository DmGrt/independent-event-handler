package com.event.handler.processor;

import com.event.handler.kafka.EventProducer;
import com.event.handler.model.Event;
import com.event.handler.repository.EventRepository;
import com.google.gson.Gson;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
public class EventProcessorImpl implements EventProcessor {
  private final EventRepository eventRepository;
  private final EventProducer eventProducer;
  private final Gson gson;

  @Override
  public void processEvent(Event event) {
    if (eventRepository.existsById(event.getId())) {
      log.info("Event with id: {} already was processed on in processing state.", event.getId());
    } else {
      Event savedEvent = eventRepository.save(event);
      eventProducer.sendMessage(gson.toJson(savedEvent));
    }
  }
}
