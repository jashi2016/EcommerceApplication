package com.kiran.ecommerce.Service;

import com.kiran.ecommerce.Entity.Address;
import com.kiran.ecommerce.Entity.Order;
import com.kiran.ecommerce.Entity.Product;
import com.kiran.ecommerce.Entity.User;

import java.util.List;

public interface EcommerceInt {
    User saveUser(User user);

    Product saveProduct(Product product);

    User getUserById(Integer id);

    Address saveAddress(Address address1);

    Product getProductById(Integer id);

    Address getAddressById(Integer id);

    Order createOrder(Order order1);

    Order getOrderById(Integer id);

    List<Product> getAllProductsByCategory(String category);

    Product deleteProductById(Integer id);
}
