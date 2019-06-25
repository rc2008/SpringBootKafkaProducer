package com.kafka.controller;


import com.kafka.json.KafkaProducerJson;
import com.kafka.json.StudentJson;
import com.kafka.simple.SimpleKafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ApplicationController {

    @Autowired
    SimpleKafkaProducer simpleKafkaProducer;

    @Autowired
    KafkaProducerJson kafkaProducerJson;

    @PostMapping(path = "/api/simple/string")
    public void getString (@RequestBody String stringData) {
        log.info("In kafka simple producer controller");
        simpleKafkaProducer.simpleProducer(stringData);
        log.info("string successfully pushed in kafka topic ");
    }

    @RequestMapping(value = "/api/json" ,method = RequestMethod.POST)
    public void getJson (@RequestBody StudentJson studentJson) throws Exception{
        log.info("In kafka json producer controller");
        kafkaProducerJson.sendJsonToTopic(studentJson);
        log.info("string successfully pushed in kafka topic ");
    }
    @RequestMapping(value="/api/ping" ,method = RequestMethod.GET)
    public String ping() {
        log.info("pong");
        return "pong";
    }
}
