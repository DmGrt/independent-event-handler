package com.event.handler.parser;

import com.event.handler.model.Event;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class EventDeserializer implements JsonDeserializer<Event> {

  @Override
  public Event deserialize(
      JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext)
      throws JsonParseException {
    Event event = new Event();
    event.setTimestamp(LocalDateTime.now());
    event.setType(jsonElement.getAsJsonObject().get("type").getAsString());
    event.setPayload(jsonElement.getAsString());
    return event;
  }
}
