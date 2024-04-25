package com.example.MenuStream.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email; // Assuming email as the contact detail

    @Column(nullable = false)
    private String deliveryAddress;

    @Column(nullable = true)
    private String paymentPreferences;

    // Constructors, getters and setters
}
