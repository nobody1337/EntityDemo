package de.Entity.demo.controller;

import de.Entity.demo.model.Item;
import de.Entity.demo.repositorys.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;
    @GetMapping
    List<Item>getItem(){
        return itemRepository.findAll();
    }

    @PostMapping
    Item createItem(@RequestBody Item item){
        return itemRepository.save(item);
    }
}
