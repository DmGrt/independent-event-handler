package com.event.handler;

import com.event.handler.config.EventHandlerConfiguration;
import com.event.handler.config.props.EventHandlerConfigurationProperties;
import com.event.handler.controller.EventHandlerController;
import com.event.handler.kafka.EventProducer;
import com.event.handler.notification.Notificator;
import com.event.handler.processor.EventProcessor;
import com.event.handler.repository.EventRepository;
import com.event.handler.service.EventProcessingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan(
    basePackageClasses = {
      Notificator.class,
      EventProcessor.class,
      EventRepository.class,
      EventHandlerController.class,
      EventProcessingService.class,
      EventProducer.class
    })
@EnableTransactionManagement
@EnableMongoRepositories
@Import(EventHandlerConfiguration.class)
public class EventHandlerApplication {

  public static void main(String[] args) {
    SpringApplication.run(EventHandlerApplication.class);
  }
}
