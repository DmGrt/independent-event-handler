package com.event.handler.service;

import com.event.handler.model.Event;
import com.event.handler.processor.EventProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventProcessingService {

  private final EventProcessor eventProcessor;

  public void processEvent(final Event event) {}
}
