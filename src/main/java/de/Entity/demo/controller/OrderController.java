package de.Entity.demo.controller;

import de.Entity.demo.model.Order;
import de.Entity.demo.repositorys.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;
    @GetMapping
    List<Order>getOrder(){
        return orderRepository.findAll();
    }
    @PostMapping
    Order createOrder(@RequestBody Order order){
        return orderRepository.save(order);
    }
}
