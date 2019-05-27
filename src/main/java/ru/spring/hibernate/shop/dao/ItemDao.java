package ru.spring.hibernate.shop.dao;

import ru.spring.hibernate.shop.entity.Item;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public interface ItemDao {

    void deleteItem(String itemId) throws SQLException;
    void createItem(Item item, String catalogId);
    void createItems(List<Item> items, String catalogId);
    List<Item> getItemsFromCatalog(String catalogId) ;
    Item getItemById(String catalogId, String itemId);
    Item getItemById(String itemId);

}
