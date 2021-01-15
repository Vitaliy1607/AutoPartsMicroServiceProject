package com.parts.partsrestapi.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

    public static final String QUEUENAME= "part_queue";
    public static final String EXCHANGE= "part_exchange";
    public static final String ROUTING_KEY= "part_key";


    @Bean
    public Queue queue(){
        return new Queue(QUEUENAME);
    }

    @Bean
    public Exchange exchange(){
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public BindingBuilder.GenericArgumentsConfigurer binding(Queue queue, Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
