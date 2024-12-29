package com.example.service;

import com.example.event.CustomApplicationListener;
import com.example.event.CustomEvent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.instrument.classloading.LoadTimeWeaver;

public class RedisService implements ApplicationEventPublisherAware, LoadTimeWeaverAware, RedisServiceInterface {

    private static Log log = LogFactory.getLog(CustomApplicationListener.class);
    private ApplicationEventPublisher publisher;
    private CustomApplicationListener customApplicationListener;

    public RedisService() {
        log.info("RedisService");
    }
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

    @Override
    public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
        System.out.println("loadTimeWeaver: " + loadTimeWeaver);
    }
}
