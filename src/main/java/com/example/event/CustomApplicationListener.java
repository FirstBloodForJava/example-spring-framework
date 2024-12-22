package com.example.event;

import org.springframework.context.ApplicationListener;

public class CustomApplicationListener implements ApplicationListener<CustomEvent> {
    public CustomApplicationListener () {

    }
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("start: " + event.start);
        System.out.println("source: " + event.getSource());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("end: " + System.currentTimeMillis());
    }
}
