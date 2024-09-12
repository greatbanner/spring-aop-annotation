package com.example.aop.demo.aop;

import java.lang.reflect.InvocationTargetException;
import java.time.Instant;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.aop.demo.Event;

@Aspect
@Component
public class AuditAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("@annotation(AuditableInt)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
       
        var result = (String)joinPoint.proceed();
        var event = getEvent(joinPoint, result);
        logger.info("User " + event.who() + " greeted with message: " + event.message() + " at: " + event.whenItHappens() + " ");
        return result;
    }

    private Event getEvent(ProceedingJoinPoint joinPoint, String result) throws Throwable{
        String userName = (String) joinPoint.getArgs()[0];
        var methodSignature = (MethodSignature) joinPoint.getSignature();
        var auditAnnotation = (AuditableInt) methodSignature.getMethod().getAnnotation(AuditableInt.class);
        EventMapper eventMapper = (EventMapper) auditAnnotation.eventMapper().getDeclaredConstructor().newInstance();
        var event = eventMapper.toEvent(userName, result);
        return event;
    }

}
