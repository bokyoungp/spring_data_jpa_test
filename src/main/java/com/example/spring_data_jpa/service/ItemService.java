package com.example.spring_data_jpa.service;

import com.example.spring_data_jpa.domain.Item;
import com.example.spring_data_jpa.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
  private final ItemRepository repository;

  public List<Item> getAllItems() {
    return repository.findAll();
  }

  public Item getOneItem(long itemId) {
    return repository.findByItemId(itemId);
  }

  public Item saveItem(Item item) {
    return repository.save(item);
  }

  public void deleteItem(long itemId) {
    repository.deleteById(itemId);
  }
}
