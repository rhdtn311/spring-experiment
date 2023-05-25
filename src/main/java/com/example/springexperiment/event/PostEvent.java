package com.example.springexperiment.event;

import org.springframework.context.ApplicationEvent;

public class PostEvent extends ApplicationEvent {

    private Long userId;

    public PostEvent(Object source, Long userId) {
        super(source);
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}
