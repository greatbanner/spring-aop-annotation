package com.example.aop.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.aop.demo.aop.AuditableInt;
import com.example.aop.demo.aop.EventMapper;

@Service
public class AuditableGreeterWithAOP {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @AuditableInt(eventMapper = EventMapper.class)
    public String greetAndAudit(String userToGreet) {
        logger.info("greeting user");
        String message = "Welcome " + userToGreet;
        return message;
    }
    
}
