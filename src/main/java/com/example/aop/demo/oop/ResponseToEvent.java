package com.example.aop.demo.oop;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.example.aop.demo.Event;

@Service
public class ResponseToEvent {

    public Event map(String response, String name) {
        return new Event(Instant.now(), name, response);
    }
}
