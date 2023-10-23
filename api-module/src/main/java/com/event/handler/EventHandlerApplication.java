package com.event.handler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.event.handler.*"})
@EntityScan(basePackages = {"com.event.handler.*"})
@EnableJpaRepositories(basePackages = {"com.event.handler.*"})
public class EventHandlerApplication {

    public static void main(String[] args){
        SpringApplication.run(EventHandlerApplication.class);
    }
}
