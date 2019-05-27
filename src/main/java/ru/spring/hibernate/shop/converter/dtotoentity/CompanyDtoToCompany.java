package ru.spring.hibernate.shop.converter.dtotoentity;

import org.springframework.stereotype.Component;
import ru.spring.hibernate.shop.dto.CompanyDto;
import ru.spring.hibernate.shop.entity.Company;
import org.springframework.core.convert.converter.Converter;

@Component
public class CompanyDtoToCompany implements Converter<CompanyDto, Company> {

    @Override
    public Company convert(CompanyDto companyDto) {
        Company company = new Company();
        company.setId(companyDto.getId());
        company.setName(companyDto.getName());
        return company;
    }
}
