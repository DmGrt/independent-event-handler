package com.event.handler.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class OrderEvent {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String eventType;
  private String eventPayload;
}
