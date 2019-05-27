package ru.spring.hibernate.shop.dao.impl;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.hibernate.shop.dao.CatalogDao;
import ru.spring.hibernate.shop.entity.Catalog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Component
public class CatalogDaoImpl implements CatalogDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createCatalog(Catalog catalog) {
        entityManager.persist(catalog);
    }

    @Override
    public void deleteCatalog(String catalogId) {
        entityManager.createNativeQuery("DELETE FROM catalog WHERE id = ? ")
                .setParameter(1, catalogId)
                .executeUpdate();
    }


    @Override
    public List<Catalog> getAllCatalogs() {
        CriteriaQuery<Catalog> query = entityManager.getCriteriaBuilder().createQuery(Catalog.class);
        query.from(Catalog.class);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Catalog getCatalogById(String catalogId) {
        return entityManager.find(Catalog.class, catalogId);
    }
}
