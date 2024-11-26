package org.delivery.api.config.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("delivery.exchange");
    }

    @Bean
    public Queue queue(){
        return new Queue("delivery.queue");
    }

    public Binding binding(
            DirectExchange directExchange,
            Queue queue
    ){
        return BindingBuilder
                .bind(queue)
                .to(directExchange)
                .with("delivery.key");
    }

    // end queue

    @Bean
    public RabbitTemplate rabbitTemplate(
            ConnectionFactory connectionFactory,
            MessageConverter messageConverter
    ){
        var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter); // object를 json 형태로 -> json 형태를 object 형태로
        return rabbitTemplate;
    }

    public MessageConverter messageConverter(
            ObjectMapper objectMapper
    ){
        return new Jackson2JsonMessageConverter(objectMapper);
    }

}
