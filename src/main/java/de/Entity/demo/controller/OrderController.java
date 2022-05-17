package de.Entity.demo.controller;

import de.Entity.demo.model.Item;
import de.Entity.demo.model.Order;
import de.Entity.demo.repositorys.ItemRepository;
import de.Entity.demo.repositorys.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ItemRepository itemRepository;

    @GetMapping
    List<Order>getOrder(){
        return orderRepository.findAll();
    }
    @PostMapping
    Order createOrder(@RequestBody Order order){
        return orderRepository.save(order);
    }

    @PutMapping("/{orderId}/items/{itemId}")
    Order enrollItemtoOrder(
            @PathVariable long orderId,
            @PathVariable long itemId
    ){
        Order order = orderRepository.findById(orderId).get();
        Item item = itemRepository.findById(itemId).get();
        order.enrollItem(item);
        return orderRepository.save(order);
    }
}
