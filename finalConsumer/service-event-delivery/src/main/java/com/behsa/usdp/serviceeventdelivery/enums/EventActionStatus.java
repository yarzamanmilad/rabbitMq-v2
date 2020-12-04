package com.behsa.usdp.serviceeventdelivery.enums;

public enum EventActionStatus {
    NOT_SEND(0),SENDED(1),SUCCESS(2),FAILED(3);
    private int value;

    EventActionStatus(int value) {
        this.value = value;
    }
}
