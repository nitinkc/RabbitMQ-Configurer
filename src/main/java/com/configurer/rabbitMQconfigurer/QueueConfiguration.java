package com.configurer.rabbitMQconfigurer;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by nichaurasia on Thursday, January/23/2020 at 1:44 PM
 */

@Configuration
public class QueueConfiguration {

    private static final String QUEUE_NAME = "MyProgrammaticQueue";

    //Programatically Creating Queue without using the dashboard
    @Bean
    Queue myQueue(){
        return new Queue(QUEUE_NAME,true);
    }

    @Bean
    Queue newQueue(){
        return QueueBuilder.durable("another_queue")
                .autoDelete()
                .exclusive()
                .build();
    }

    @Bean
    ConnectionFactory connectionFactory(){
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");
        return cachingConnectionFactory;
    }
}