package com.target.kafka.controller;

import com.target.kafka.service.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class KafkaController {


    @Autowired
    KafkaProducerService kafkaProducerService;

    @GetMapping(value = "/kafka/publish")
    public void updateMessage(@RequestParam("topic") String topic, @RequestParam String message){
        kafkaProducerService.publish(topic,message);
        log.info("sent message {}", message );

    }
}
