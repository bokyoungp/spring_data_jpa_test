package com.example.spring_data_jpa.controller;

import com.example.spring_data_jpa.domain.Item;
import com.example.spring_data_jpa.service.ItemService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
  private final ItemService service;

  @GetMapping
  public List<Item> getAllItems() {
    return service.getAllItems();
  }

  @GetMapping("/{itemId}")
  public Item getOneItem(@PathVariable("itemId") long itemId) {
    return service.getOneItem(itemId);
  }

  @PostMapping
  public Item createItem(@RequestBody Item item) {
    return service.saveItem(item);
  }

  @PutMapping("/{itemId}")
  public Item updateItem(@PathVariable("itemId") long itemId, @RequestBody Item item) {
    Item oneItem = service.getOneItem(itemId);
    oneItem.setItemName(item.getItemName());
    return service.saveItem(item);
  }

  @DeleteMapping("/{itemId}")
  public void deleteItem(@PathVariable("itemId") long itemId) {
    service.deleteItem(itemId);
  }
}
