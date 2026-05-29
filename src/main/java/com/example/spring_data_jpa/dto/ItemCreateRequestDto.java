package com.example.spring_data_jpa.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemCreateRequestDto {
  private String itemName;
  private int price;
  private int cost;
  private String privateInfo;
}
