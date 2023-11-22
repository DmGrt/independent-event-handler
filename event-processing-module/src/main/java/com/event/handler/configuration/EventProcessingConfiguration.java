package com.event.handler.configuration;

import com.event.handler.model.Event;
import com.event.handler.parser.EventDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventProcessingConfiguration {
  @Bean
  public Gson gsonBean() {
    return new GsonBuilder()
        .registerTypeAdapter(Event.class, new EventDeserializer())
        .serializeNulls()
        .create();
  }
}
