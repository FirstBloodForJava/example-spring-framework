package com.example.event;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {

    long start;

    public CustomEvent(Object source) {
        super(source);
    }

    public CustomEvent(Object source, long start) {
        this(source);
        this.start = start;
    }
}
