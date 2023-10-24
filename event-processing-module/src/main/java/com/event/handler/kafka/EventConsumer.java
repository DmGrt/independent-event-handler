package com.event.handler.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventConsumer {

  @KafkaListener(topics = {"event-handler-1", "event-handler-2"})
  public void consume(String message) {
    log.info(String.format("#### -> Consumed message -> %s", message));
  }
}
