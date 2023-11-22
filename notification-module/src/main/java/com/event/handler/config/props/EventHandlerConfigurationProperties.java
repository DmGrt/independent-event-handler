package com.event.handler.config.props;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties("handler.config.mail")
public class EventHandlerConfigurationProperties {
  public List<String> receivers;
  public long notificationPeriod;
}
