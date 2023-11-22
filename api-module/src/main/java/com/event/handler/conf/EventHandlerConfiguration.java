package com.event.handler.conf;

import java.net.http.HttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventHandlerConfiguration {
  @Bean
  public HttpClient httpClient() {
    return HttpClient.newBuilder().build();
  }
}
