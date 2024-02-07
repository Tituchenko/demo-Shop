package ru.gb.demo.Shop.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import ru.gb.demo.Shop.aspects.TrackUserAction;
import ru.gb.demo.Shop.models.Product;
import ru.gb.demo.Shop.repo.ProductRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class ShopService {
    ProductRepo productRepo;


    @TrackUserAction
    public List<Product> getAllTasks() {
        return productRepo.findAll();
    }

    public Product getProductById(Long id){
        return productRepo.findById(id).get();
    }
}
