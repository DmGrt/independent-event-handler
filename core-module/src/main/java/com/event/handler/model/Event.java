package com.event.handler.model;


import jakarta.persistence.Lob;
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
  @Id private Long id;

  private String type;
  @Lob private String payload;
  private long timestamp;
}
