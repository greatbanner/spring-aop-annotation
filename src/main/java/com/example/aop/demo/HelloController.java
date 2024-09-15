package com.example.aop.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController()
@RequestMapping("/greeting")
public class HelloController {

    @Autowired
    private AuditableGreeter auditableGreeter;

    @Autowired
    private AuditableGreeterWithAOP auditableGreeterWithAOP;

    @Autowired
    private AuditableGreeterWithFuntional auditableGreeterWithFuntional;

    @GetMapping("aop")
    public String greetUserWithAop(@RequestParam(name = "user") String user) {
        return auditableGreeterWithAOP.greetAndAudit(user);
    }

    @GetMapping("oo")
    public String greetUserAsOO(@RequestParam(name = "user") String user) {
        return auditableGreeter.greetAndAudit(user);
    }
    
    @GetMapping("fun")
    public String greetUserAsFun(@RequestParam(name = "user") String user) {
        return auditableGreeterWithFuntional.greetAndAudit(user);
    }
}
