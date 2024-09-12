package com.example.aop.demo.aop;

import java.time.Instant;

import com.example.aop.demo.Event;

public class EventMapper {

    public Event toEvent(String input, String result){
        return new Event(Instant.now(), input, result);
    }
}
