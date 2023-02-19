package com.kiran.ecommerce.Controller;

import com.kiran.ecommerce.Entity.Address;
import com.kiran.ecommerce.Entity.Order;
import com.kiran.ecommerce.Entity.Product;
import com.kiran.ecommerce.Entity.User;
import com.kiran.ecommerce.Repository.UserRepository;
import com.kiran.ecommerce.Service.EcommerceInt;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ecommerce")
public class EcommerceController {

    @Autowired
    EcommerceInt ecommerceInt;
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return ecommerceInt.saveUser(user);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Integer id){
       return ecommerceInt.getUserById(id);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        return ecommerceInt.saveProduct(product);
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Integer id){
        return ecommerceInt.getProductById(id);
    }

    @PostMapping("/address")
    public Address createAddress(@RequestBody String address){
        JSONObject json = new JSONObject(address);
        Address address1 = new Address();
        address1.setLandmark(json.getString("landmark"));
        address1.setName(json.getString("name"));
        address1.setState(json.getString("state"));
        address1.setZipcode(json.getString("zipcode"));
        address1.setPhoneNumber(json.getString("phoneNumber"));
        String userid = json.getString("userId");
        User user = ecommerceInt.getUserById(Integer.valueOf(userid));
        address1.setUserId(user);
        return ecommerceInt.saveAddress(address1);
    }

    @GetMapping("/address/{id}")
    public Address getaddressById(@PathVariable Integer id){
        return ecommerceInt.getAddressById(id);
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody String order){
        JSONObject jsonObject = new JSONObject(order);
        Order order1 = new Order();
        User user = ecommerceInt.getUserById(Integer.valueOf(jsonObject.getString("userId")));
        Product product = ecommerceInt.getProductById(Integer.valueOf(jsonObject.getString("productId")));
        Address address = ecommerceInt.getAddressById(Integer.valueOf(jsonObject.getString("addressId")));
        order1.setAddressId(address);
        order1.setUserId(user);
        order1.setProductId(product);
        return ecommerceInt.createOrder(order1);
    }
}
