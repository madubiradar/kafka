package com.target.kafka.service;



import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducerService {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public void publish(String topic, String message){

        kafkaTemplate.send(topic,message);
    }
}
