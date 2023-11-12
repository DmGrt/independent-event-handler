package com.event.handler.model;


import jakarta.persistence.Lob;
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

  @Id private Long productId;
  private String name;
  @Lob private String description;

  private String eventType;
  private String eventPayload;
  private long timestamp;
}
