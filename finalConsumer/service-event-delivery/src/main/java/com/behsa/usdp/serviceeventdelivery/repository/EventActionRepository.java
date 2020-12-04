package com.behsa.usdp.serviceeventdelivery.repository;

import com.behsa.usdp.serviceeventdelivery.domain.EventAction;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventActionRepository extends JpaRepository<EventAction,Long> {
    Optional<EventAction> findById(Long id);
    List<EventAction> findAllBy();

   // Optional<EventAction> findEventActionByPK_RABBIT_EVENT_ACTION(Long id);
}
