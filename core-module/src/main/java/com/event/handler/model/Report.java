package com.event.handler.model;


import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("report")
@RequiredArgsConstructor
public class Report {
  @Id private UUID id;

  private String reportType;
  private String content;
  private LocalDateTime generationDate;
}
