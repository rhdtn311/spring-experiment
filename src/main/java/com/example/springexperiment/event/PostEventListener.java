package com.example.springexperiment.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PostEventListener implements ApplicationListener<PostEvent> {

    public void onApplicationEvent(PostEvent event) {
        log.info("alarm add by {}", event.getUserId());
    }
}
