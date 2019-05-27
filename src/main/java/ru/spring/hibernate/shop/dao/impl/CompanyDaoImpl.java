package ru.spring.hibernate.shop.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.hibernate.shop.dao.CompanyDao;
import ru.spring.hibernate.shop.entity.Company;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class CompanyDaoImpl implements CompanyDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createCompany(Company company) {
        entityManager.persist(company);
    }

    @Override
    public Company getCompanyById(String companyId) {
        return entityManager.find(Company.class, companyId);
    }
}
