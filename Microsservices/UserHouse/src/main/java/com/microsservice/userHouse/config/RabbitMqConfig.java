package com.microsservice.userHouse.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMqConfig {

    @Bean
    public ConnectionFactory rabbitConnectionFactory() {
        final CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("myuser");
        connectionFactory.setPassword("mypassword");
        return connectionFactory;
    }


    @Bean
    public RabbitTemplate listenerContainerFactory() {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(rabbitConnectionFactory());
        return rabbitTemplate;
    }
}
