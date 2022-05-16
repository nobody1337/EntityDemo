package de.Entity.demo.controller;

import de.Entity.demo.model.Item;
import de.Entity.demo.repositorys.ItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    ItemRepository itemRepository;
    @GetMapping
    List<Item>getItem(){
        return itemRepository.findAll();
    }

    Item createItem(@RequestBody Item item){
        return itemRepository.save(item);
    }
}
