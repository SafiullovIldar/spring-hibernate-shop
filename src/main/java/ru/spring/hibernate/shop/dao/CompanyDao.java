package ru.spring.hibernate.shop.dao;

import ru.spring.hibernate.shop.entity.Company;
import org.springframework.stereotype.Component;

@Component
public interface CompanyDao {

    void createCompany(Company company);
    Company getCompanyById(String companyId);
}
