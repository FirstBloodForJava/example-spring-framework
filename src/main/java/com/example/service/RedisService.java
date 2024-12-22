package com.example.service;

import com.example.event.CustomApplicationListener;
import com.example.event.CustomEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class RedisService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;
    private CustomApplicationListener customApplicationListener;
    public String get(String key) {
        publisher.publishEvent(new CustomEvent(this, System.currentTimeMillis()));
        return key;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void setCustomApplicationListener(CustomApplicationListener customApplicationListener) {
        this.customApplicationListener = customApplicationListener;
    }
}
