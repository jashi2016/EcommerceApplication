package com.kiran.ecommerce.Entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer orderId;

    @ManyToOne
    @JoinColumn(name = "user_id_user_id")
    User userId;
    @ManyToOne
    @JoinColumn(name = "product_id_product_id")
    Product productId;

    @ManyToOne
    @JoinColumn(name = "address_id_address_id")
    Address addressId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }
}
