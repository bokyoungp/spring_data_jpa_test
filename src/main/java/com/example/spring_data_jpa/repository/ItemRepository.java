package com.example.spring_data_jpa.repository;

import com.example.spring_data_jpa.domain.Item;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
  Item findByItemId(long itemId);

  @EntityGraph(attributePaths = {"category"}) // category 도 left outer join 으로 함께 로딩
  List<Item> findAll();
}
