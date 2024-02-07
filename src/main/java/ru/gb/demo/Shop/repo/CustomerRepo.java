package ru.gb.demo.Shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.demo.Shop.models.Customer;
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {
    Customer findByName(String name);
}
