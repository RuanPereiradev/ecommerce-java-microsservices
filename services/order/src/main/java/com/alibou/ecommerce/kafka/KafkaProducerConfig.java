package com.alibou.ecommerce.kafka;

import com.fasterxml.jackson.databind.JsonSerializer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    //Create Produces Kafka
    @Bean
    public ProducerFactory<String, OrderConfirmation> producerFactory(){

       // internal settings map
        Map<String, Object> props = new HashMap<>();

        //kafka broker address
        props.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "localhost:9092"
        );

        //transform the key (String) into bytes before sending to Kafka
        props.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class
        );

        //transform the object(OrderConfirmation) in JSON
        props.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class
        );
        return new DefaultKafkaProducerFactory<>(props);
    }

    //Create Kafka Template
    @Bean
    public KafkaTemplate<String, OrderConfirmation> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}
