package com.event.handler.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("profile")
@RequiredArgsConstructor
public class Profile {
  @Id private Long id;
  private User user;
  private String email;
}
