package com.ms.springkafka.controller;

import com.ms.springkafka.service.ProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/log/{message}")
    public String message(@PathVariable("message") String message){
        producerService.sendMessage(message);
        return "OK";
    }

  
}
