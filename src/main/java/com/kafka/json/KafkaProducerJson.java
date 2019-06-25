package com.kafka.json;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerJson  {

    @Autowired
    KafkaTemplate<String, StudentJson> jsonKafkaTemplate;
    public void sendJsonToTopic(StudentJson studentJson) throws Exception{
        ProducerRecord<String,StudentJson> producerRecord = new ProducerRecord("jsonTopic" ,
                String.valueOf(studentJson.getId())
                ,new ObjectMapper().writeValueAsString(studentJson));
        jsonKafkaTemplate.send(producerRecord);
    }
}
