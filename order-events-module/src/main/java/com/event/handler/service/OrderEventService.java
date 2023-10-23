package com.event.handler.service;

import com.event.handler.model.OrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderEventService {
  public void processOrderEvent(OrderEvent orderEvent) {
    // Implement the logic to process order-specific events.
  }
}
