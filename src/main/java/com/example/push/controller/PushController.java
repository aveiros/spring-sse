package com.example.push.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class PushController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PushController.class);

    @GetMapping("/v1/events")
    public SseEmitter handleSse() {
        SseEmitter emitter = new SseEmitter(60000L);

        emitter.onCompletion(() -> {
            System.out.println("Subscription completed");
        });

        emitter.onTimeout(() -> {
            System.out.println("Subscription timed out");
        });


        LOGGER.info("event request!!!");

        return emitter;
    }
}
