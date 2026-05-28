package com.exmple.spring_data_jpa.controller;

import com.exmple.spring_data_jpa.domain.Item;
import com.exmple.spring_data_jpa.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
