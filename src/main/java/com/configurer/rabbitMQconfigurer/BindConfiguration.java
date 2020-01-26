package com.configurer.rabbitMQconfigurer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by nitin on Sunday, January/26/2020 at 1:40 AM
 */
@Configuration
public class BindConfiguration {
    @Autowired
    private ExchangeConfiguration exchangeConfiguration;
    @Autowired
    private QueueConfiguration queueConfiguration;

    @Bean
    Binding binding(){
        //return new Binding(QUEUE_NAME,Binding.DestinationType.QUEUE,EXCHANGE_NAME,"topic",null);
        return BindingBuilder
                .bind(queueConfiguration.myQueue())
                .to(exchangeConfiguration.myExchange())
                .with("topic")
                .noargs();
    }
}
