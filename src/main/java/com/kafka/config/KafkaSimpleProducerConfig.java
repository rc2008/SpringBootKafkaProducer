package com.kafka.config;


import com.kafka.json.StudentJson;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaSimpleProducerConfig {

    @Bean
    public Map<String,Object> KafkaProducerConfig() {
        Map<String,Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092,localhost:9093,localhost:9094");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,CustomPartitioner.class);
        return config;
    }

    @Bean
    public DefaultKafkaProducerFactory defaultKafkaProducerFactory() {
        DefaultKafkaProducerFactory<String,Object> stringDefaultKafkaProducerFactory =
                new DefaultKafkaProducerFactory<>(KafkaProducerConfig());
        return stringDefaultKafkaProducerFactory;
     }

     @Bean
     public KafkaTemplate<String,String> kafkaTemplate() {
        KafkaTemplate<String,String > kafkaTemplate = new KafkaTemplate<>(defaultKafkaProducerFactory());
        return kafkaTemplate;
     }

    @Bean
    public KafkaTemplate<String, StudentJson> jsonKafkaTemplate() {
        KafkaTemplate<String,StudentJson > kafkaTemplate = new KafkaTemplate<>(defaultKafkaProducerFactory());
        return kafkaTemplate;
    }
}
