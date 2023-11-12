package com.event.handler.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("orderevent")
@RequiredArgsConstructor
public class OrderEvent {
  @Id private Long id;

  private String eventType;
  private String eventPayload;
}
