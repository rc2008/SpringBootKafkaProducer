package com.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
@Slf4j
public class KafkaAppMain  {

    public static void main(String[] args) {
        SpringApplication.run(KafkaAppMain.class,args);
    }

}
