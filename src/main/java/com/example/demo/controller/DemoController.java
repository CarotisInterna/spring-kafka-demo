package com.example.demo.controller;

import com.example.demo.domain.DemoClass;
import com.example.demo.service.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class DemoController {

    private Sender sender;

    @PostMapping(value = "/send")
    public ResponseEntity hello(@RequestBody DemoClass demo) {
        sender.send(demo);
        return ok().body("created");
    }

    @Autowired
    public DemoController(Sender sender) {
        this.sender = sender;
    }
}
