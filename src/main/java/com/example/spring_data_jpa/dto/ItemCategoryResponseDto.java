package com.example.spring_data_jpa.dto;

import com.example.spring_data_jpa.domain.Category;
import com.example.spring_data_jpa.domain.Item;
import lombok.*;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemCategoryResponseDto {
  private long itemId;
  private String itemName;
  private String categoryName;

  public static ItemCategoryResponseDto getItemResponse(Item item) {
    String categoryName = Optional.ofNullable(item.getCategory())
        .map(Category::getCategoryName)
        .orElse("카테고리 없음");       // null 대신 기본값

    return new ItemCategoryResponseDto(
        item.getItemId(),
        item.getItemName(),
        categoryName
    );
  }
}
