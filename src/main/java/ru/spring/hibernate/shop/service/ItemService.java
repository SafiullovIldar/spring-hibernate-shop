package ru.spring.hibernate.shop.service;

import org.springframework.stereotype.Component;
import ru.spring.hibernate.shop.dto.ItemDto;

import java.sql.SQLException;
import java.util.List;

@Component
public interface ItemService {

    List<ItemDto> getItemsFromCatalog(String id);
    ItemDto getItemById(String catalogId, String itemId);
    void createItems(List<ItemDto> items, String catalogId);
    void createItem(ItemDto itemDto, String catalogId);
    void deleteItem(String itemId) throws SQLException;
    public ItemDto getItemById(String itemId);

}
