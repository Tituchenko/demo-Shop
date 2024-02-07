package ru.gb.demo.Shop.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    double balance;
}
