package com.example.demo.amqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("itemExchange");
    }

    @Bean
    public Queue queue() {
        return new Queue("currencyQueue");
    }

    @Bean
    public Binding binding(DirectExchange directExchange,
                           Queue queue) {
        return BindingBuilder.bind(queue)
                .to(directExchange)
                .with("getExchangeRate");
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
