package com.behsa.usdp.serviceeventdelivery.domain;

import com.behsa.usdp.serviceeventdelivery.enums.EventActionStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
//@Table(name = "VW_RABBIT_EVENT_ACTION", schema = "USSD_MIGRATE_CRM", catalog = "")
@RequiredArgsConstructor
@Data
@Accessors(chain = true)

public class EventAction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_RABBIT_EVENT_ACTION")
    private Long id;
    @Enumerated(EnumType.ORDINAL)
    private EventActionStatus status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //@JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime serviceReceiveDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   // @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime serviceFinishDate;
    private LocalDateTime deliverDate;


}
