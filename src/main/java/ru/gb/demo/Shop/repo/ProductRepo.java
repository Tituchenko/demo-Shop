package ru.gb.demo.Shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.demo.Shop.models.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
}
