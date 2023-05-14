package com.springbootrabbitmqimpl.consumer;

import com.springbootrabbitmqimpl.dto.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import static com.springbootrabbitmqimpl.Constants.*;

@Slf4j
@Component
public class User {

    @RabbitListener(queues = QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
//        log.info("Message received from queue : {}", orderStatus);
    }
}
