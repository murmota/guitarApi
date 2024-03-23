package com.example.guitarApi.modules.entities.productEntities.products;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Product", schema = "public", catalog = "postgres")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "articul")
    private int articul;
    @Column(name = "Name")
    private String name;
    @Column(name = "Company")
    private String company;
    @Column(name = "Price")
    private double price;
    @Column(name = "Description")
    private String description;
    @Column(name = "ConnectionType")
    private String connectionType;
    @Column(name = "Material")
    private String material;
    @Column(name = "Length")
    private double length;
    @Column(name = "Weight")
    private double weight;
    @Column(name = "Bulk")
    private String bulk;
    @Column(name = "Watt")
    private double watt;
    @Column(name = "EffectType")
    private String effectType;
    @Column(name = "StringQuantity")
    private int StringQuantity;
    @Column(name = "Color")
    private String Color;
}
