package com.event.handler.notification;

import com.event.handler.config.props.EventHandlerConfigurationProperties;
import com.event.handler.model.Event;
import com.event.handler.repository.EventRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StaffingMailNotificator implements Notificator {

  private static final String FIRST_MESSAGE_PART = "New event/s appear: \r\n";

  private final JavaMailSender javaMailSender;
  private final EventHandlerConfigurationProperties eventHandlerConfigurationProperties;
  private final EventRepository eventRepository;

  @Value("${spring.mail.username}")
  private String fromEmail;

  @Override
  public void notifySubscribersWith() {
    try {
      final SimpleMailMessage mailMessage = new SimpleMailMessage();
      mailMessage.setSubject("Event Handler Update");
      mailMessage.setFrom(fromEmail);
      mailMessage.setTo(eventHandlerConfigurationProperties.getReceivers().toArray(new String[0]));
      mailMessage.setText(getTextMessage());
      javaMailSender.send(mailMessage);
      log.info("EVENTS APPEARED:\n{}", mailMessage);
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  private String getTextMessage() {
    LocalDateTime startProcessing = LocalDateTime.now();
    List<Event> newEvents =
        eventRepository.findAllByTimestampAfter(
            LocalDateTime.now()
                .minusMinutes(eventHandlerConfigurationProperties.getNotificationPeriod()));
    LocalDateTime endProcessing = LocalDateTime.now();
    log.info(
        "{} were processed for {} milliseconds",
        newEvents.size(),
        Duration.between(startProcessing, endProcessing));
    return FIRST_MESSAGE_PART
        + newEvents.stream().map(Event::getMainInfo).collect(Collectors.joining("\r\n--------\n"));
  }
}
