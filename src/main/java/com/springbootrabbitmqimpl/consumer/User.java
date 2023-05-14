package com.springbootrabbitmqimpl.consumer;

import com.springbootrabbitmqimpl.config.MessagingConfig;
import com.springbootrabbitmqimpl.dto.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class User {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        log.info("Message received from queue : {}", orderStatus);
    }
}
