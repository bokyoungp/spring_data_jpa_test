package com.example.spring_data_jpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="item_table")
public class Item {
  @Id
  @GeneratedValue(strategy =  GenerationType.IDENTITY)
  private long itemId;
  @Column(name="name", length = 45)
  private String itemName;
  private int price;
  private int cost;
  @Column(length = 450)
  private String privateInfo;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id")
  private Category category;
}
