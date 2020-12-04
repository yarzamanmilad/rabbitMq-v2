package com.behsa.usdp.serviceeventdelivery.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {

    static final String directExchangeName = "service-event-deliver";
    static final String directQueueName = "eventService/deliver";
    @Bean
    ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }
    @Bean
    Queue queue() {
        return new Queue(directQueueName, true);
    }
    @Bean
    DirectExchange getDirectExchange(){
        return new DirectExchange(directExchangeName);
    }
    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("serviceEvent");
    }
    @Bean
    MessageListenerAdapter getMessageListenerAdapter(){
        MessageListenerAdapter adapter=new MessageListenerAdapter();
        return adapter;
    }

}
