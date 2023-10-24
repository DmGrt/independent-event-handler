package com.event.handler.model;

import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("event")
@RequiredArgsConstructor
public class Event {
  @Id private UUID id;

  private String eventType;
  private String eventPayload;
  private long timestamp;
}
