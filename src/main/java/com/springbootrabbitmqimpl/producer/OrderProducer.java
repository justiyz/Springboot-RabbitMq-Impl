package com.springbootrabbitmqimpl.producer;

import com.springbootrabbitmqimpl.dto.Order;
import com.springbootrabbitmqimpl.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static com.springbootrabbitmqimpl.Constants.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderProducer {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/{restaurantName}")
    public String placeOrder(@RequestBody Order order, @PathVariable String restaurantName){
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "Order placed successfully in %s"+ restaurantName);
        template.convertAndSend(EXCHANGE, ROUTING_KEY, orderStatus);
        return "SUCCESS !";
    }
}
