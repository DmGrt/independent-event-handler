package com.event.handler.service;

import com.event.handler.model.CustomerEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerEventService {
  public void processCustomerEvent(CustomerEvent customerEvent) {
    // Implement the logic to process customer-specific events.
  }
}
