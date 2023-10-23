package com.event.handler.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Event {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @Column private String eventType;
  @Column private String eventPayload;
  @Column private long timestamp;
}
