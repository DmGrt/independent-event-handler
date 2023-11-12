package com.event.handler.controller;

import com.event.handler.exception.EventNotFoundException;
import com.event.handler.exception.EventProcessingException;
import com.event.handler.exception.EventStorageException;
import com.event.handler.exception.EventTransformationException;
import com.event.handler.exception.EventValidationException;
import com.event.handler.exception.ReportNotFoundException;
import com.event.handler.model.Event;
import com.event.handler.model.Report;
import com.event.handler.service.EventService;
import com.event.handler.service.ReportingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/handler")
public class EventHandlerController {

  private final EventService eventService;
  private final ReportingService reportingService;

  @GetMapping("/events/{eventId}")
  public ResponseEntity<Event> getEventById(@PathVariable Long eventId) {
    try {
      Event event = eventService.getEventById(eventId);
      if (event != null) {
        return ResponseEntity.ok(event);
      } else {
        throw new EventNotFoundException("Event with ID " + eventId + " not found.");
      }
    } catch (EventNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/events")
  public ResponseEntity<String> createEvent(@RequestBody Event event) {
    try {
      eventService.processEvent(event);
      return ResponseEntity.status(HttpStatus.CREATED).body("Event created successfully.");
    } catch (EventValidationException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Event validation failed.");
    } catch (EventTransformationException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Event transformation failed.");
    } catch (EventStorageException e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Event storage failed.");
    } catch (EventProcessingException e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Event processing failed.");
    }
  }

  @GetMapping("/reports/{reportId}")
  public ResponseEntity<Report> getReportById(@PathVariable Long reportId) {
    try {
      Report report = reportingService.getReportById(reportId);
      if (report != null) {
        return ResponseEntity.ok(report);
      } else {
        throw new ReportNotFoundException("Report with ID " + reportId + " not found.");
      }
    } catch (ReportNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }
}
