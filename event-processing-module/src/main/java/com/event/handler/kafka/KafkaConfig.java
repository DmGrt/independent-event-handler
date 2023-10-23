package com.event.handler.kafka;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@EnableKafka
@Configuration
@RequiredArgsConstructor
public class KafkaConfig {

  @Bean
  public NewTopic topic1() {
    return TopicBuilder.name("event-handler-1").build();
  }

  @Bean
  public NewTopic topic2() {
    return TopicBuilder.name("event-handler-2").build();
  }
}
