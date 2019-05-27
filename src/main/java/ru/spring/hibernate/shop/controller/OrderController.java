package ru.spring.hibernate.shop.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.spring.hibernate.shop.dto.PurchaseDto;
import ru.spring.hibernate.shop.service.OrderService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/purchase")
public class OrderController {

    private OrderService orderService;

    @PostMapping
    public void createPurchase(@RequestParam("customer_id") String customerId,
                               @RequestParam("item_id") String itemId,
                               @RequestParam(value = "amount", defaultValue = "1") Integer amount,
                               @RequestParam("catalog_id") String catalogId,
                               @RequestParam(value = "promocode_id", defaultValue = "null") String promoCodeId) {
        orderService.createPurchase(customerId, itemId, amount, catalogId, promoCodeId);
    }

    @GetMapping
    public List<PurchaseDto> getPurchases(@RequestParam("customer_id") String customerId) {
        return orderService.getPurchases(customerId);
    }

    @GetMapping("/{purchase_id}")
    public PurchaseDto getPurchaseById(@RequestParam("customer_id") String customerId,
                                    @PathVariable("purchase_id") String purchaseId) {
        return orderService.getPurchaseById(customerId, purchaseId);
    }

    @GetMapping("/history")
    public List<PurchaseDto> getPurchaseHistory(@RequestParam("customer_id") String customerId) {
        return orderService.getPurchaseHistory(customerId);
    }
}
