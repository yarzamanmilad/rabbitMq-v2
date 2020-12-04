package com.example.producer.producer;

import com.example.producer.domain.EventAction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
@RequiredArgsConstructor
public class EventActionProducer {
    private final RabbitTemplate template;
    private  ObjectMapper mapper=new ObjectMapper();
    public void sendMessage(EventAction eventAction){

        try {
            String json = mapper.writeValueAsString(eventAction);
            System.out.println(json);
            try {
                EventAction eventAction1=mapper.readValue(json,EventAction.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            template.convertAndSend("service-event-deliver","serviceEvent",json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
