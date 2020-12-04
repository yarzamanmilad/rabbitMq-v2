package com.behsa.usdp.serviceeventdelivery.service;

import com.behsa.usdp.serviceeventdelivery.domain.EventAction;
import com.behsa.usdp.serviceeventdelivery.enums.EventActionStatus;
import com.behsa.usdp.serviceeventdelivery.repository.EventActionRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class EventActionService {
    private final EventActionRepository eventActionRepository;

    public void update(EventAction eventAction) {

        Optional<EventAction> optionalEventAction = findByid(eventAction);
        if(optionalEventAction.isPresent()){
            updateStatusAndDelivertDate(optionalEventAction.get());
        }else{
            log.error("record not found for this id: "+eventAction.getId());
        }

    }

    private EventAction updateStatusAndDelivertDate(EventAction eventAction) {
        eventAction.setStatus(EventActionStatus.SUCCESS);
        eventAction.setDeliverDate(LocalDateTime.now());
        return eventActionRepository.save(eventAction);

    }

    private Optional<EventAction> findByid(EventAction eventAction) {
        Long id=eventAction.getId();

        final Optional<EventAction> byId = eventActionRepository.findById(id);

        return byId;
    }

    public void save(EventAction eventAction) {
        eventActionRepository.save(eventAction);
    }
}
