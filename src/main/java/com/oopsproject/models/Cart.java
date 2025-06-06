package com.oopsproject.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

// Using the annotation so that this class is mapped to a table in the database
@Entity
@Table(name = "cart") // The name of the table
public class Cart {
    // This attribute is to be used as the primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // It will have auto generated (auto incremented values)
    private Long cartId;

    // Defining the relationship with User entity
    @OneToOne
    @JoinColumn(name = "userId", nullable = false)
    private Users user;

    // Defining the relationship with CartItem entities
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems;

    // Default constructor
    public Cart() {
    }

    // Parametrized constructor
    public Cart(Users user) {
        this.user = user;
    }

    // Getters for the field attributes
    public Long getCartId() {
        return cartId;
    }

    public Users getUser() {
        return user;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    // Setters for the field attributes
    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    // Formatting the object information
    @Override
    public String toString() {
        return "Cart{" + "id=" + cartId + ", user=" + (user != null ? user.getUserId() : null) +
                ", cartItems=" + (cartItems != null ? cartItems.size() : 0) + '}';
    }
}