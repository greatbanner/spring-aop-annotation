package com.example.aop.demo;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AuditableGreeter implements Auditable {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    public Event audit(String userToGreet) {
        var event = new Event(Instant.now(), userToGreet, "");
        logger.info("User " + event.who() + " greeted at: " + event.whenItHappens() + " ");
        return event;
    }

    public String greetAndAudit(String userToGreet) {
        String message = "Welcome " + userToGreet;
        audit(userToGreet);
        return message;
    }
    
}
