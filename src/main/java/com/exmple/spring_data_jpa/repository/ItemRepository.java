package com.exmple.spring_data_jpa.repository;

import com.exmple.spring_data_jpa.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
  Item findByItemId(long itemId);
}
