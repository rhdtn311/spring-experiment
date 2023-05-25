package com.example.springexperiment.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Test
    void post_메소드_호출_시_알람_발송() {
        postService.post(1L);
    }

}