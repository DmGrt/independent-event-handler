package com.event.handler.notification;

import com.event.handler.config.props.EventHandlerConfigurationProperties;
import com.event.handler.model.Event;
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
public class StaffingMailNotificator implements Notificator<Event> {

  private static final String FIRST_MESSAGE_PART = "New event/s appear: \r\n";

  private final JavaMailSender javaMailSender;
  private final EventHandlerConfigurationProperties eventHandlerConfigurationProperties;

  @Value("${spring.mail.username}")
  private String fromEmail;

  @Override
  public void notifySubscribersWith(final List<Event> newElements) {
    try {
      final SimpleMailMessage mailMessage = new SimpleMailMessage();
      mailMessage.setSubject("Event Handler Update");
      mailMessage.setFrom(fromEmail);
      mailMessage.setTo(eventHandlerConfigurationProperties.getReceivers().toArray(new String[0]));
      mailMessage.setText(getTextMessage(newElements));
      javaMailSender.send(mailMessage);
      log.info("EVENTS APPEARED:\n{}", mailMessage);
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  private String getTextMessage(final List<Event> newElements) {
    return FIRST_MESSAGE_PART
        + newElements.stream().map(Event::getMainInfo).collect(Collectors.joining("\r\n"));
  }
}
