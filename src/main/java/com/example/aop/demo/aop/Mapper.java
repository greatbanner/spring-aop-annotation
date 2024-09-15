package com.example.aop.demo.aop;


import com.example.aop.demo.Event;

public interface Mapper {

    Event toEvent(Object response, Object[] args);
}
