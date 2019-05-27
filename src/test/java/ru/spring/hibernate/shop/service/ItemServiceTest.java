package ru.spring.hibernate.shop.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.spring.hibernate.shop.config.AppConfig;
import ru.spring.hibernate.shop.dao.ItemDao;
import ru.spring.hibernate.shop.dto.ItemDto;
import ru.spring.hibernate.shop.entity.Item;
import ru.spring.hibernate.shop.util.Util;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class ItemServiceTest {

    @Autowired
    private ConversionService conversionService;

    @Mock
    private ItemDao itemDao;

    @Autowired
    @InjectMocks
    private ItemService itemService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenCreateItemCalledVerified() {
        ItemDto itemDto = Util.createTestDtoItem("1");
        Item item = conversionService.convert(itemDto, Item.class);

        doNothing().when(itemDao).createItem(item, "1");
        itemService.createItem(itemDto, "1");

        verify(itemDao, times(1)).createItem(item, "1");
    }

    @Test
    public void whenDeleteItemCalledVerified() throws SQLException {
        doNothing().when(itemDao).deleteItem("1");
        itemService.deleteItem("1");

        verify(itemDao, times(1)).deleteItem("1");
    }

    @Test
    public void shouldGetExpectedItemsCountFromCatalog() {
        List<Item> items = Util.createTestItems("1", "2");
        when(itemDao.getItemsFromCatalog("1")).thenReturn(items);

        assertEquals(2, itemService.getItemsFromCatalog("1").size());
    }
}