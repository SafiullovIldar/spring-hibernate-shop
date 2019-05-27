package ru.spring.hibernate.shop.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.hibernate.shop.dao.CustomerDao;
import ru.spring.hibernate.shop.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Component
public class CustomerDaoImpl implements CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        CriteriaQuery<Customer> query = entityManager.getCriteriaBuilder().createQuery(Customer.class);
        query.from(Customer.class);
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Customer getCustomerById(String customerId) {
        return entityManager.find(Customer.class, customerId);
    }
}
