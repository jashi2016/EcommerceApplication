package com.kiran.ecommerce.Controller;

import com.kiran.ecommerce.Entity.Address;
import com.kiran.ecommerce.Entity.Order;
import com.kiran.ecommerce.Entity.Product;
import com.kiran.ecommerce.Entity.User;
import com.kiran.ecommerce.Exception.EcommerceCustomException;
import com.kiran.ecommerce.Service.EcommerceInt;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        try{
            return ecommerceInt.getUserById(id);
        }
        catch (Exception e) {
            throw new EcommerceCustomException("User Not Found");
        }
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        return ecommerceInt.saveProduct(product);
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Integer id){
        try{
            return ecommerceInt.getProductById(id);
        }
        catch (Exception e) {
            throw new EcommerceCustomException("Product Not Found");
        }
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
        try{
            User user = ecommerceInt.getUserById(Integer.valueOf(userid));
            address1.setUserId(user);
        }
        catch (Exception e) {
            throw new EcommerceCustomException("No User Found");
        }
        return ecommerceInt.saveAddress(address1);
    }

    @GetMapping("/address/{id}")
    public Address getaddressById(@PathVariable Integer id){
        try{
            return ecommerceInt.getAddressById(id);
        }
        catch (Exception e) {
            throw new EcommerceCustomException("Address Not Found");
        }
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody String order){
        JSONObject jsonObject = new JSONObject(order);
        Order order1 = new Order();


        try{
            User user = ecommerceInt.getUserById(Integer.valueOf(jsonObject.getString("userId")));
            order1.setUserId(user);
        }
        catch (Exception e) {
            throw new EcommerceCustomException("No User Found");
        }

        try{
            Address address = ecommerceInt.getAddressById(Integer.valueOf(jsonObject.getString("addressId")));
            order1.setAddressId(address);
        }
        catch (Exception e) {
            throw new EcommerceCustomException("No Address Found");
        }

        try{
            Product product = ecommerceInt.getProductById(Integer.valueOf(jsonObject.getString("productId")));
            order1.setProductId(product);
        }
        catch (Exception e) {
            throw new EcommerceCustomException("No Product Found");
        }
        order1.setProductQuantity(Integer.parseInt(jsonObject.getString("productQuantity")));
        return ecommerceInt.createOrder(order1);
    }

    @GetMapping("/order/{id}")
    public Order getOrderById(@PathVariable Integer id){
        try{
            return ecommerceInt.getOrderById(id);
        }
        catch (Exception e){
            throw new EcommerceCustomException("Order Not Found");
        }
    }

    @PostMapping("/products/getAll")
    public List<Product> getAllProductsByCategory(@RequestParam String category){
            List<Product> products = ecommerceInt.getAllProductsByCategory(category);
            if(products.isEmpty())
                throw new EcommerceCustomException("No Products Found");
            else
                return products;
    }

    @DeleteMapping("/products/delete/{id}")
    public Product deleteProductById(@PathVariable Integer id){
        return ecommerceInt.deleteProductById(id);
    }
}
