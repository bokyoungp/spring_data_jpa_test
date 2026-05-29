package com.example.spring_data_jpa.dto;

import com.example.spring_data_jpa.domain.Item;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemCreateResponseDto {
  private long itemId;
  private String itemName;

  public static ItemCreateResponseDto getItemResponse(Item item) {
    return new ItemCreateResponseDto(item.getItemId(), item.getItemName());
  }
}
