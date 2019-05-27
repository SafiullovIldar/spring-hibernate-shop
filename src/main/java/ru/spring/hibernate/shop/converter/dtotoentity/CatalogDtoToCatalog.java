package ru.spring.hibernate.shop.converter.dtotoentity;

import org.springframework.stereotype.Component;
import ru.spring.hibernate.shop.dto.ItemDto;
import ru.spring.hibernate.shop.entity.Item;
import ru.spring.hibernate.shop.dto.CatalogDto;
import ru.spring.hibernate.shop.entity.Catalog;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

@Component
public class CatalogDtoToCatalog implements Converter<CatalogDto, Catalog> {

    @Override
    public Catalog convert(CatalogDto catalogDto) {
        ItemDtoToItem dtoToItem = new ItemDtoToItem();
        Catalog catalog = new Catalog();
        catalog.setId(catalogDto.getId());
        catalog.setName(catalogDto.getName());

        List<Item> items = new ArrayList<>();
        List<ItemDto> itemDtos = catalogDto.getItems();

        for (ItemDto itemDto : itemDtos) {
            items.add(dtoToItem.convert(itemDto));
        }

        catalog.setItems(items);
        return catalog;
    }
}
