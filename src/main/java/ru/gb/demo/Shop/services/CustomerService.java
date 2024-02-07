package ru.gb.demo.Shop.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.demo.Shop.models.Customer;
import ru.gb.demo.Shop.repo.CustomerRepo;

@Service
@AllArgsConstructor
public class CustomerService {
    CustomerRepo customerRepo;

    public Customer getCustomerByName(String name){
        return customerRepo.findByName(name);
    }
}
