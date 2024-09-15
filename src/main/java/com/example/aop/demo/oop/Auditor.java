package com.example.aop.demo.oop;

import java.util.function.Function;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.aop.demo.Event;

public class Auditor<T> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public T processAndAudit(Supplier<T> toAudit, Function<T, Event> mapper){
        var result = toAudit.get();
        var eventToAudit = mapper.apply(result);
        auditEvent(eventToAudit);
        return result;
    }

    private void auditEvent(Event event){
        logger.info("User " + event.who() + " greeted with message: " + event.message() + " at: " + event.whenItHappens() + " ");
    }
}
