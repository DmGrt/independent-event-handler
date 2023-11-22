package com.event.handler.model;

import jakarta.persistence.Lob;
import java.time.LocalDateTime;
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

  private String type;
  @Lob private String payload;
  private LocalDateTime timestamp;

  public String getMainInfo() {
    return "Event: "
        + type
        + "\n"
        + "id: "
        + id
        + "\n"
        + "Was processed on: "
        + timestamp
        + "\n"
        + "Event payload length: "
        + payload.length()
        + "\n";
  }
}
