package com.example.aop.demo.aop;

import java.time.Instant;

import com.example.aop.demo.Event;

public class EventMapper implements Mapper {

    public Event toEvent(String input, String result){
        return new Event(Instant.now(), input, result);
    }

    @Override
    public Event toEvent(Object response, Object[] args) {
        return toEvent((String)args[0], (String)response);
    }
}
