package ru.gb.demo.Shop.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Double price;
    int amount;
    int reserved;

}
