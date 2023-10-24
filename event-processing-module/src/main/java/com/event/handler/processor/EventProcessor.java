package com.event.handler.processor;

import com.event.handler.model.Event;
import org.springframework.stereotype.Component;

public interface EventProcessor {

  void processEvent(Event event);
}
