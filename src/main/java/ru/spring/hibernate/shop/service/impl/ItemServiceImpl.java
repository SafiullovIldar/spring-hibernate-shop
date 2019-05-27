package ru.spring.hibernate.shop.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ru.spring.hibernate.shop.dao.ItemDao;
import ru.spring.hibernate.shop.dto.ItemDto;
import ru.spring.hibernate.shop.entity.Item;
import ru.spring.hibernate.shop.service.ItemService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

    private ItemDao itemDao;
    private ConversionService conversion;

    @Override
    public List<ItemDto> getItemsFromCatalog(String catalogId) {
        List<Item> itemsFromCatalog = itemDao.getItemsFromCatalog(catalogId);
        List<ItemDto> itemDtos = new ArrayList<>();

        for (Item item : itemsFromCatalog) {
            itemDtos.add(conversion.convert(item, ItemDto.class));
        }

        return itemDtos;
    }

    @Override
    public ItemDto getItemById(String catalogId, String itemId) {
        Item itemById = itemDao.getItemById(catalogId, itemId);
        return conversion.convert(itemById, ItemDto.class);
    }

    @Override
    public ItemDto getItemById(String itemId) {
        Item itemById = itemDao.getItemById( itemId);
        return conversion.convert(itemById, ItemDto.class);
    }

    @Override
    public void createItems(List<ItemDto> itemsDto, String catalogId) {
        List<Item> items = new ArrayList<>();
        if (itemsDto != null) {
            for (ItemDto itemDto : itemsDto) {
                items.add(conversion.convert(itemDto, Item.class));
            }
        }

        itemDao.createItems(items, catalogId);
    }

    @Override
    public void createItem(ItemDto itemDto, String catalogId) {
        Item item = conversion.convert(itemDto, Item.class);
        itemDao.createItem(item, catalogId);
    }

    @Override
    public void deleteItem(String itemId) throws SQLException {
        itemDao.deleteItem(itemId);
    }

}
