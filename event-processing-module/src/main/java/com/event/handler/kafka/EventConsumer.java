package com.event.handler.kafka;

import com.event.handler.model.Event;
import com.event.handler.processor.EventProcessor;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventConsumer {

  private final EventProcessor eventProcessor;
  private final Gson gson;

  @KafkaListener(topics = {"event-handler-1", "event-handler-2"})
  public void consume(String message) {
    Event event = gson.fromJson(gson.toJson(message), Event.class);
    eventProcessor.processEvent(event);
    log.info("Event with id: {} was consumed.", event.getId());
  }
}
