package ru.spring.hibernate.shop.dao;

import ru.spring.hibernate.shop.entity.Catalog;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public interface CatalogDao {

    void createCatalog(Catalog catalog);
    void deleteCatalog(String catalogId);
    List<Catalog> getAllCatalogs();
    Catalog getCatalogById(String catalogId);
}
