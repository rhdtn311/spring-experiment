package com.example.springexperiment.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AlarmService {

    public void add(Long userId) {
        log.info("alarm add by {}", userId);
    }
}
