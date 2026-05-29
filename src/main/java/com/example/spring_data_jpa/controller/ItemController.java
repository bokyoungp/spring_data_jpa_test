package com.example.spring_data_jpa.controller;

import com.example.spring_data_jpa.domain.Item;
import com.example.spring_data_jpa.dto.*;
import com.example.spring_data_jpa.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
  private final ItemService service;

//  @GetMapping
//  public List<Item> getAllItems() {
//    return service.getAllItems();
//  }

    @GetMapping
  public List<ItemCategoryResponseDto> getAllItems() {
    return service.getAllItems();
  }

  @GetMapping("/{itemId}")
  public ItemCategoryResponseDto getOneItem(@PathVariable("itemId") long itemId) {
    return service.getOneItem(itemId);
  }

  @PostMapping
  public ItemCreateResponseDto createItem(@RequestBody ItemCreateRequestDto itemDto)  {
    log.info("dto data - {} , {}, {}, {}", itemDto.getItemName(), itemDto.getPrice(), itemDto.getCost(), itemDto.getPrivateInfo());
    return service.saveItem(itemDto);
  }

  @PutMapping("/{itemId}")
  public ItemUpdateResponseDto updateItem(@PathVariable("itemId") long itemId, @RequestBody ItemUpdateRequestDto itemDto) {
    log.info("==> 전달된 itemName() : {} ", itemDto.getItemName());
    return service.updateItem(itemId, itemDto);
  }

  @DeleteMapping("/{itemId}")
  public void deleteItem(@PathVariable("itemId") long itemId) {
    service.deleteItem(itemId);
  }
}
