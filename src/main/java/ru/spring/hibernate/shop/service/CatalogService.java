package ru.spring.hibernate.shop.service;

import org.springframework.stereotype.Component;
import ru.spring.hibernate.shop.dto.CatalogDto;

import java.util.List;

@Component
public interface CatalogService {

    void createCatalog(CatalogDto dto);
    void deleteCatalog(String catalogId);
    List<CatalogDto> getAllCatalogs();
    CatalogDto getCatalogById(String catalogId);
}
