package com.event.handler.model;

import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("user")
@RequiredArgsConstructor
public class User {
  @Id private UUID id;

  private String firstName;
  private String secondName;
  private Date birthDay;
  private String phoneNumber;
}
