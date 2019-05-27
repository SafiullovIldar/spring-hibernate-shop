package ru.spring.hibernate.shop.converter.entitytodto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.spring.hibernate.shop.dto.ItemDto;
import ru.spring.hibernate.shop.entity.Item;

@Component
public class ItemToItemDto implements Converter<Item, ItemDto> {

    @Override
    public ItemDto convert(Item item) {
        ItemDto dto = new ItemDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setAvailability(item.getAvailability());
        dto.setPrice(item.getPrice());
        return dto;
    }
}
