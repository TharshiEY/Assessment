package com.niq.assessment.common;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue productQueue() {
        return new Queue("product-queue");
    }

    @Bean
    public Queue shopperQueue() {
        return new Queue("shopper-queue");
    }
}
