package com.event.handler.processor;

import com.event.handler.model.Event;

public interface EventProcessor {

  void processEvent(Event event);
}
