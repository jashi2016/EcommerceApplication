package com.kiran.ecommerce.Service;

import com.kiran.ecommerce.Entity.Address;
import com.kiran.ecommerce.Entity.Order;
import com.kiran.ecommerce.Entity.Product;
import com.kiran.ecommerce.Entity.User;
import com.kiran.ecommerce.Repository.AddressRepository;
import com.kiran.ecommerce.Repository.OrderRepository;
import com.kiran.ecommerce.Repository.ProductRepository;
import com.kiran.ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EcommerceIntImpl implements EcommerceInt{
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Address getAddressById(Integer id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Order createOrder(Order order1) {
        return orderRepository.save(order1);
    }

    @Override
    public Address saveAddress(Address address1) {
        return addressRepository.save(address1);
    }
}
