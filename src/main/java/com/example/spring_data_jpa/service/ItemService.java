package com.example.spring_data_jpa.service;

import com.example.spring_data_jpa.domain.Item;
import com.example.spring_data_jpa.dto.*;
import com.example.spring_data_jpa.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ItemService {
  private final ItemRepository repository;

  @Transactional(readOnly = true)
  public List<ItemCategoryResponseDto> getAllItems() {
    List<Item> itemList = repository.findAll(); // DO 를 반환
    log.info("item list 가져옴");
    List<ItemCategoryResponseDto> dtoList = itemList.stream().map(ItemCategoryResponseDto::getItemResponse)
        .toList(); // DO => DTO
    log.info("item list 를 DTO로 변환함");
    return dtoList;
  }

  @Transactional(readOnly = true)
  public Item getOneItem(long itemId) {
    return repository.findByItemId(itemId);
  }

  public ItemCreateResponseDto saveItem(ItemCreateRequestDto itemDto)  {
    // DTO 를 DO 로 변환해서 repository 로 전달
    Item item = new Item(0, itemDto.getItemName(), itemDto.getPrice(), itemDto.getCost(), itemDto.getPrivateInfo(), null);
    // repository 의 응답인 DO 를 DTO 로 변환해서 controller 에게 전달
    Item save = repository.save(item);
    return  ItemCreateResponseDto.getItemResponse(save);
  }

  public ItemUpdateResponseDto updateItem(long itemId, ItemUpdateRequestDto itemDto) {
    log.info("service ==> {}", itemDto);
    // DTO 를 DO 로 변환해서 repository 로 전달
    Item oneItem = repository.findByItemId(itemId);
    oneItem.setItemName(itemDto.getItemName());
    Item save = repository.save(oneItem);
    // repository 의 응답인 DO 를 DTO 로 변환해서 controller 에게 전달
    return ItemUpdateResponseDto.getItemResponse(save);
  }

  public void deleteItem(long itemId) {
    repository.deleteById(itemId);
  }
}
