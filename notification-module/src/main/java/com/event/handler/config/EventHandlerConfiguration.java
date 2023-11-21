package com.event.handler.config;

import com.event.handler.config.props.EventHandlerConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(EventHandlerConfigurationProperties.class)
public class EventHandlerConfiguration {}
