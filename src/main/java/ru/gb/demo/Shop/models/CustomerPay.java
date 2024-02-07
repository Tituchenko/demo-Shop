package ru.gb.demo.Shop.models;

import lombok.Data;

@Data
public class CustomerPay {
    Long fromId;
    Long toId;
    double sum;

    public CustomerPay(Long fromId, Long toId, double sum) {
        this.fromId = fromId;
        this.toId = toId;
        this.sum = sum;
    }
}
