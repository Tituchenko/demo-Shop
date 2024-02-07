package ru.gb.demo.Shop.models;

import lombok.Data;

@Data
public class ProductReserved {
    Long id;
    int toReserved;

    public ProductReserved(Long id, int toReserved) {
        this.id = id;
        this.toReserved = toReserved;
    }
}
