package com.behsa.usdp.serviceeventdelivery.consumer;


import com.behsa.usdp.serviceeventdelivery.domain.EventAction;
import com.behsa.usdp.serviceeventdelivery.repository.EventActionRepository;
import com.behsa.usdp.serviceeventdelivery.service.EventActionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Service
@Log4j2
public class EventActionConsumer {

    private final ObjectMapper mapper;
    private final EventActionService eventActionService;
    private final EventActionRepository eventActionRepository;


    @RabbitListener(queues = "eventService/deliver")
    private void listen(String  msg){

        try {
            EventAction eventAction = mapper.readValue(msg, EventAction.class);
            eventActionService.update(eventAction);

        } catch (IOException e) {
            e.printStackTrace();
            log.error("objectMapper error");
        }

    }
}
