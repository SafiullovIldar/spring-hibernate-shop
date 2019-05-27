package ru.spring.hibernate.shop.service;

import org.springframework.stereotype.Service;
import ru.spring.hibernate.shop.dto.CompanyDto;

@Service
public interface CompanyService {

    void createCompany(CompanyDto companyDto);
    CompanyDto getCompanyById(String companyId);
}
