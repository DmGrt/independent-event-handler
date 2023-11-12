package com.event.handler.parser;

import com.event.handler.model.Event;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class EventDeserializer implements JsonDeserializer<Event> {

  @Override
  public Event deserialize(
      JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext)
      throws JsonParseException {
    return null;
  }
}
