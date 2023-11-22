package com.event.handler.kafka;

import com.event.handler.model.Event;
import com.event.handler.processor.EventProcessor;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
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

  @KafkaListener(topics = {"eventHandler1", "eventHandler2"})
  public void consume(String message) {
    try {
      processMessage(message);
      return;
    } catch (Exception e) {
      log.info("Move to process as batch.");
    }
    JsonArray jsonElements = gson.fromJson(message, JsonArray.class);

    for (JsonElement next : jsonElements) {
      processMessage(next.toString());
    }
  }

  private void processMessage(String message) {
    Event event = gson.fromJson(message, Event.class);
    eventProcessor.processEvent(event);
    log.info("Event with id: {} was consumed.", event.getId());
  }
}
