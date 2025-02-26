package com.brightkut.springboot_serverless;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

    @GetMapping(path = "/hello")
    public ResponseEntity<Message> hello() {
        return new ResponseEntity<>(new Message().setMessage("Hello Dude"),HttpStatus.OK);
    }
    
}