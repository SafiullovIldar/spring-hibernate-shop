package ru.spring.hibernate.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.spring.hibernate.shop.converter.dtotoentity.*;
import ru.spring.hibernate.shop.converter.entitytodto.*;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new PromoCodeDtoToPromoCode());
        registry.addConverter(new CatalogDtoToCatalog());
        registry.addConverter(new CustomerDtoToCustomer());
        registry.addConverter(new ItemDtoToItem());
        registry.addConverter(new PurchaseDtoToPurchase());
        registry.addConverter(new ShoppingCartDtoToShoppingCart());
        registry.addConverter(new CompanyDtoToCompany());
        registry.addConverter(new CreditCardDtoToCreditCard());

        registry.addConverter(new PromoCodeToPromoCodeDto());
        registry.addConverter(new CatalogToCatalogDto());
        registry.addConverter(new CustomerToCustomerDto());
        registry.addConverter(new ItemToItemDto());
        registry.addConverter(new PurchaseToPurchaseDto());
        registry.addConverter(new ShoppingCartToShoppingCartDto());
        registry.addConverter(new CompanyToCompanyDto());
        registry.addConverter(new CreditCardToCreditCardDto());
    }
}

