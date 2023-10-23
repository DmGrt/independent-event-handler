package com.event.handler.controller;

import com.event.handler.kafka.EventProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/kafka")
public class KafkaController {

  private final EventProducer producer;

  @PostMapping(value = "/publish")
  public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
    this.producer.sendMessage(message);
  }
}
