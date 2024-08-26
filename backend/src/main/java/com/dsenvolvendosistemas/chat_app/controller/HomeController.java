package com.dsenvolvendosistemas.chat_app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<String> HomeController(){
        return new ResponseEntity<String>("Wellcome to our whatsapp API using Spring boot", HttpStatus.OK);
    }
}
