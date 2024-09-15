package com.example.aop.demo;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aop.demo.oop.Auditor;
import com.example.aop.demo.oop.ResponseToEvent;

@Service
public class AuditableGreeterWithFuntional {

    @Autowired
    private ResponseToEvent responseToEvent;

    public String greetAndAudit(String userToGreet) {
       Auditor<String> adittor = new Auditor<>();
       return adittor.processAndAudit( ()-> greet(userToGreet), response -> responseToEvent.map(response, userToGreet));
    }

    private String greet(String userToGreet){
        String message = "Welcome " + userToGreet;
        return message;
    }

}
