package com.example.spring_data_jpa.dto;

import com.example.spring_data_jpa.domain.Item;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemUpdateResponseDto {
  private long itemId;
  private String itemName;
  private int price;

  public static ItemUpdateResponseDto getItemResponse(Item item) {
    return new ItemUpdateResponseDto(
        item.getItemId(),
        item.getItemName(),
        item.getPrice());
  }
}
