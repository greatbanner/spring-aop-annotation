package com.example.aop.demo.oop;

import java.util.function.Function;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.aop.demo.Event;

public class Auditor<T> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Supplier<T> methodToAudit;
    private Function<T, Event> responseToMapper;


    public Auditor(Supplier<T> methodToAudit, Function<T, Event> responseToMapper) {
        this.methodToAudit = methodToAudit;
        this.responseToMapper = responseToMapper;
    }

    public T processAndAudit(){
        var result = methodToAudit.get();
        var eventToAudit = responseToMapper.apply(result);
        auditEvent(eventToAudit);
        return result;
    }

    private void auditEvent(Event event){
        logger.info("User " + event.who() + " greeted with message: " + event.message() + " at: " + event.whenItHappens() + " ");
    }
}
