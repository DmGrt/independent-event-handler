package com.event.handler.kafka;

import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventProducer {

  private static final String TOPIC = "eventHandler1";

  private final KafkaTemplate<String, String> kafkaTemplate;

  void sendMessage(String message, String topicName) {
    kafkaTemplate.send(topicName, message);
  }

  public void sendMessage(String message) {
    log.info(String.format("#### -> Producing message -> %s", message));
    kafkaTemplate.send(TOPIC, message);
  }

  void sendMessageWithCallback(String message) {
    CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC, message);

    future.thenApply(r -> r + " supplied successfully");
  }
}
