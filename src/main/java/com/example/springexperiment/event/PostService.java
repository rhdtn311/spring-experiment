package com.example.springexperiment.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void post(Long userId) {
        log.info("post start");

        applicationEventPublisher.publishEvent(new PostEvent(this, userId));

        log.info("post done");
    }
}
