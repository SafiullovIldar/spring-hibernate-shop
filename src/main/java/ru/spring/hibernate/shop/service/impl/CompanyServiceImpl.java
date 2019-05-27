package ru.spring.hibernate.shop.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ru.spring.hibernate.shop.dao.CompanyDao;
import ru.spring.hibernate.shop.dto.CompanyDto;
import ru.spring.hibernate.shop.entity.Company;
import ru.spring.hibernate.shop.service.CompanyService;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private CompanyDao companyDao;
    private ConversionService conversion;

    @Override
    public void createCompany(CompanyDto companyDto) {
        Company company = conversion.convert(companyDto, Company.class);
        companyDao.createCompany(company);
    }

    @Override
    public CompanyDto getCompanyById(String companyId) {
        Company company = companyDao.getCompanyById(companyId);
        return conversion.convert(company, CompanyDto.class);
    }
}
