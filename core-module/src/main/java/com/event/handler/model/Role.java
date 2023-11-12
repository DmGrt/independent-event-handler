package com.event.handler.model;

import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("role")
@RequiredArgsConstructor
public class Role {
  @Id private Long id;

  private String name;

  private Set<User> users;
}
