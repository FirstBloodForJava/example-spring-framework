package com.example.event;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;

public class CustomApplicationListener implements ApplicationListener<CustomEvent> {
    private static Log log = LogFactory.getLog(CustomApplicationListener.class);

    public String pwd;
    public CustomApplicationListener () {
        log.info("CustomApplicationListener");
    }
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("start: " + event.start);
        System.out.println("source: " + event.getSource());
        log.info("pwd: " + pwd);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("end: " + System.currentTimeMillis());
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
