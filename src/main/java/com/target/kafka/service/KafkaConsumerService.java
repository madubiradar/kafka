package com.target.kafka.service;



import com.target.kafka.entity.Message;
import com.target.kafka.entity.MessageType;
import com.target.kafka.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class KafkaConsumerService {

    @Autowired
    MessageRepository messageRepository;

    @KafkaListener(topics = "banking", groupId = "group_id")
    public void receiveMessageFromDemoTopic(@Payload String message){
        log.info("Message {} received from banking topic", message);
        Message msgObject = getMessageObject();
        msgObject.setMessage(message);
        msgObject.setMessageReferenceId(UUID.randomUUID().toString());
        msgObject.setMessageType(MessageType.BANKING);
        messageRepository.save(msgObject);
        log.info("Message {} received from banking topic", message);
    }

    @KafkaListener(topics = "finance", groupId = "group_id")
    public void receiveMessageFromPaymentTopic(@Payload ConsumerRecord<String , String> record){
        log.info("Message {} received from finance topic", record.value());
        Message msgObject = getMessageObject();
        msgObject.setMessage(record.value());
        msgObject.setMessageReferenceId(UUID.randomUUID().toString());
        msgObject.setMessageType(MessageType.FINANCIAL);
        messageRepository.save(msgObject);
    }
    @KafkaListener(topics = "healthcare", groupId = "group_id")
    public void receiveMessageFromHealthcareTopic(@Payload ConsumerRecord<String , String> record){
        log.info("Message {} received from finance topic", record.value());
        Message msgObject = getMessageObject();
        msgObject.setMessage(record.value());
        msgObject.setMessageReferenceId(UUID.randomUUID().toString());
        msgObject.setMessageType(MessageType.HEALTHCARE);
        messageRepository.save(msgObject);
    }

    private Message getMessageObject(){
        return new Message();
    }

}
