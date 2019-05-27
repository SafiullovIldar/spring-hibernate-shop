package ru.spring.hibernate.shop.converter.entitytodto;

import org.springframework.stereotype.Component;
import ru.spring.hibernate.shop.dto.CatalogDto;
import ru.spring.hibernate.shop.dto.ItemDto;
import ru.spring.hibernate.shop.entity.Catalog;
import ru.spring.hibernate.shop.entity.Item;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

@Component
public class CatalogToCatalogDto implements Converter<Catalog, CatalogDto> {

    @Override
    public CatalogDto convert(Catalog catalog) {
        ItemToItemDto itemToItemDto = new ItemToItemDto();
        CatalogDto dto = new CatalogDto();
        dto.setId(catalog.getId());
        dto.setName(catalog.getName());

        if (catalog.getItems() != null) {
            List<Item> items = catalog.getItems();
            List<ItemDto> itemDtos = new ArrayList<>();

            for (Item item : items) {
                itemDtos.add(itemToItemDto.convert(item));
            }

            dto.setItems(itemDtos);
        }

        return dto;
    }
}
