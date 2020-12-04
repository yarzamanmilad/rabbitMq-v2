package com.behsa.usdp.serviceeventdelivery;

import com.behsa.usdp.serviceeventdelivery.domain.EventAction;
import com.behsa.usdp.serviceeventdelivery.repository.EventActionRepository;
import com.behsa.usdp.serviceeventdelivery.service.EventActionService;
import javafx.scene.Node;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
@Log4j2
public class ServiceEventDeliveryApplication implements CommandLineRunner {

    private EventAction eventAction;
    @Autowired
    private EventActionService eventActionService;
    @Autowired
    private EventActionRepository eventActionRepository;
    public static void main(String[] args) {

        SpringApplication.run(ServiceEventDeliveryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        eventAction=new EventAction();
        LocalDateTime now;

        for (long i = 1; i < 200; i++) {
            now = LocalDateTime.now();


            eventAction.setId((i))
                    .setServiceFinishDate(now)
                    .setServiceReceiveDate(now);
            eventActionService.save(eventAction);
            System.out.println();

        }
       // eventActionService.update(eventAction);
       // System.out.println(eventActionRepository.findById(1l).toString());
    }
}
