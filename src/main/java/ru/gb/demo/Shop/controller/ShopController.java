package ru.gb.demo.Shop.controller;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.gb.demo.Shop.aspects.TrackUserAction;
import ru.gb.demo.Shop.models.Customer;
import ru.gb.demo.Shop.models.CustomerPay;
import ru.gb.demo.Shop.models.Product;
import ru.gb.demo.Shop.models.ProductReserved;
import ru.gb.demo.Shop.services.CustomerService;
import ru.gb.demo.Shop.services.ShopService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("")
public class ShopController {
    ShopService shopService;
    CustomerService customerService;
    private  static final String WAREHOUSE_API = "http://localhost:8090/reserved";
    private  static final String PAY_API = "http://localhost:8070/pay";

    private HttpHeaders headers;
    private RestTemplate template;
    @GetMapping("")
    public String getAllTasks(Model model){
        List<Product> products=shopService.getAllTasks();
        model.addAttribute("products",products);
        Customer shop=customerService.getCustomerByName("Shop");
        Customer user=customerService.getCustomerByName("User");
        model.addAttribute("shop",shop);
        model.addAttribute("user",user);
        return "index.html";

    }

    @PostMapping("/buy")
    public String buyProduct(Long id,Integer amount, Model model){
        ProductReserved productReserved=new ProductReserved(id,amount);
        Customer shop=customerService.getCustomerByName("Shop");
        Customer user=customerService.getCustomerByName("User");
        Product product=shopService.getProductById(id);
        CustomerPay customerPay=new CustomerPay(user.getId(), shop.getId(), product.getPrice()*amount );
        reservedAndPay(productReserved,customerPay);
        return getAllTasks(model);

    }

    @Transactional
    public void reservedAndPay(ProductReserved productReserved, CustomerPay customerPay){
        HttpEntity<ProductReserved> requestReserved = new HttpEntity<>(productReserved);
        HttpEntity<CustomerPay> requestPay = new HttpEntity<>(customerPay);

        template.exchange(WAREHOUSE_API, HttpMethod.POST,requestReserved, ProductReserved.class);
        template.exchange(PAY_API, HttpMethod.POST,requestPay, CustomerPay.class);




    }


}
