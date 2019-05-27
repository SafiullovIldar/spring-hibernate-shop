package ru.spring.hibernate.shop.payment;

public interface PaymentStrategy {

    void pay(int amount);
}
