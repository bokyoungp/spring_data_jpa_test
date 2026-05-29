package com.example.spring_data_jpa.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemUpdateRequestDto {
  private long itemId;
  private String itemName;
}
