package ru.spring.hibernate.shop.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ru.spring.hibernate.shop.dao.CatalogDao;
import ru.spring.hibernate.shop.dto.CatalogDto;
import ru.spring.hibernate.shop.entity.Catalog;
import ru.spring.hibernate.shop.service.CatalogService;
import ru.spring.hibernate.shop.service.ItemService;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private CatalogDao catalogDao;
    private ItemService itemService;
    private ConversionService conversion;

    @Override
    public void createCatalog(CatalogDto dto) {
        Catalog catalog = conversion.convert(dto, Catalog.class);
        catalogDao.createCatalog(catalog);
        itemService.createItems(dto.getItems(), catalog.getId());
    }

    @Override
    public void deleteCatalog(String catalogId) {
        catalogDao.deleteCatalog(catalogId);
    }

    @Override
    public List<CatalogDto> getAllCatalogs() {
        List<Catalog> allCatalogs = catalogDao.getAllCatalogs();
        List<CatalogDto> catalogDtos = new ArrayList<>();

        for (Catalog catalog : allCatalogs) {
            catalogDtos.add(conversion.convert(catalog, CatalogDto.class));
        }

        return catalogDtos;
    }

    @Override
    public CatalogDto getCatalogById(String catalogId) {
        Catalog catalog = catalogDao.getCatalogById(catalogId);
        return conversion.convert(catalog, CatalogDto.class);
    }
}
