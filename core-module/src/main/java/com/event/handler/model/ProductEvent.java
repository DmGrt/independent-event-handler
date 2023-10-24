package com.event.handler.model;

import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("productevent")
@RequiredArgsConstructor
public class ProductEvent {

  @Id private UUID productId;

  private String eventType;
  private String eventPayload;
  private long timestamp;
}
