package ru.spring.hibernate.shop.converter.dtotoentity;

import org.springframework.stereotype.Component;
import ru.spring.hibernate.shop.dto.ItemDto;
import ru.spring.hibernate.shop.entity.Item;
import org.springframework.core.convert.converter.Converter;

@Component
public class ItemDtoToItem implements Converter<ItemDto, Item> {

    @Override
    public Item convert(ItemDto itemDto) {
        Item item = new Item();
        item.setId(itemDto.getId());
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        item.setAvailability(itemDto.getAvailability());
        return item;
    }
}
