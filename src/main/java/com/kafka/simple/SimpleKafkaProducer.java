package com.kafka.simple;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SimpleKafkaProducer {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    public void simpleProducer(String inputString) {
        kafkaTemplate.send("simpleStringTopic", inputString);
        log.info("data  {} is pushed to kafka topic : " ,inputString);
    }
}
