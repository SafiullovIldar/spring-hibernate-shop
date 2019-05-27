package ru.spring.hibernate.shop.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.spring.hibernate.shop.dto.PromoCodeDto;
import ru.spring.hibernate.shop.service.PromoCodeService;

@RestController
@AllArgsConstructor
@RequestMapping("promocode")
public class PromoCodeController {

    private PromoCodeService promoCodeService;

    @GetMapping("/{id}")
    public PromoCodeDto getPromoCode(@PathVariable("id") String promoCodeId) {
        return promoCodeService.getPromoCode(promoCodeId);
    }

    @PostMapping
    public void createPromoCode(@RequestBody PromoCodeDto dto) {
        promoCodeService.createPromoCode(dto);
    }
}
