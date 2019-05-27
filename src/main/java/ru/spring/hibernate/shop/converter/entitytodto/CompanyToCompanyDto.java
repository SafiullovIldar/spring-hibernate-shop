package ru.spring.hibernate.shop.converter.entitytodto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.spring.hibernate.shop.dto.CompanyDto;
import ru.spring.hibernate.shop.entity.Company;

@Component
public class CompanyToCompanyDto implements Converter<Company, CompanyDto> {

    @Override
    public CompanyDto convert(Company company) {
        CompanyDto dto = new CompanyDto();
        dto.setId(company.getId());
        dto.setName(company.getName());
        return dto;
    }
}
