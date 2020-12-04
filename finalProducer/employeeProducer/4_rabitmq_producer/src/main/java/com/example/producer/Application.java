package com.example.producer;

import com.example.producer.domain.EventAction;
import com.example.producer.producer.EventActionProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
//@EnableScheduling
@RequiredArgsConstructor
public class Application  implements CommandLineRunner {
    @Autowired

    private final EventAction eventAction;
    private final EventActionProducer eventActionProducer;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LocalDateTime now;

        for (long i = 2; i < 300; i++) {
             now = LocalDateTime.now();


            eventAction.setId((i))
                    .setServiceFinishDate(now)
            .setServiceReceiveDate(now);

           eventActionProducer.sendMessage(eventAction);
        }
    }
}
