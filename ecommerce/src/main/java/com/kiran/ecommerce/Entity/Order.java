package com.kiran.ecommerce.Entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer orderId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id_user_id")
    User userId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id_product_id")
    Product productId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id_address_id")
    Address addressId;

    Integer productQuantity;

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
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
