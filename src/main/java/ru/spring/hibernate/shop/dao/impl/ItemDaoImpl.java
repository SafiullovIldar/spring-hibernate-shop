package ru.spring.hibernate.shop.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.hibernate.shop.dao.ItemDao;
import ru.spring.hibernate.shop.entity.Item;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class ItemDaoImpl implements ItemDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void deleteItem(String itemId) {
        entityManager.remove(getItemById(itemId));
    }

    @Override
    @Transactional
    public void createItem(Item item, String catalogId) {
        entityManager.createNativeQuery("INSERT INTO item VALUES (?,?,?,?,?)")
                .setParameter(1, item.getId())
                .setParameter(2, item.getName())
                .setParameter(3, item.getPrice())
                .setParameter(4, item.getAvailability())
                .setParameter(5, catalogId)
                .executeUpdate();
    }

    @Override
    public void createItems(List<Item> items, String catalogId) {
        for (Item item : items) {
            createItem(item, catalogId);
        }
    }

    @Override
    public List<Item> getItemsFromCatalog(String catalogId) {
        return entityManager.createQuery("SELECT i FROM Item i WHERE i.catalogId = " + catalogId).getResultList();
    }

    @Override
    public Item getItemById(String catalogId, String itemId) {
        return (Item) entityManager.createNativeQuery("SELECT * FROM item WHERE catalog_id = ? AND id = ? ")
                .setParameter(1, catalogId)
                .setParameter(2, itemId)
                .getSingleResult();
    }

    @Override
    public Item getItemById(String itemId) {
        return entityManager.find(Item.class, itemId);
    }
}
