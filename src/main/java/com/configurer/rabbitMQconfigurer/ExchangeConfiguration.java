package com.configurer.rabbitMQconfigurer;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.event.DocumentEvent;

/**
 * Created by nichaurasia on Thursday, January/23/2020 at 5:46 PM
 */

@Configuration
public class ExchangeConfiguration {

    private static final String EXCHANGE_NAME = "MyProgrammaticTopicExchange";

    @Bean
    Exchange myExchange(){
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME)
                .durable(true)
                .build();
    }

    @Bean
    Exchange exampleEx(){
        return new TopicExchange("ExExchange");
    }

    @Bean
    Exchange example2Ex(){
        return ExchangeBuilder.directExchange("Ex2ndExchange")
                .autoDelete()
                .internal()
                .build();
    }

    @Bean
    Exchange newEx(){
        return ExchangeBuilder.topicExchange("ztopic_exchange")
                .autoDelete()
                .durable(true)
                .internal()
                .build();
    }

    @Bean
    Exchange newExFanout(){
        return ExchangeBuilder.fanoutExchange("zfanout_exchange")
                .autoDelete()
                .durable(false)
                .internal()
                .build();
    }

    @Bean
    Exchange newExHEaders(){
        return ExchangeBuilder.headersExchange("zheaders_exchange")
                .autoDelete()
                .durable(false)
                .internal()
                .build();
    }
}