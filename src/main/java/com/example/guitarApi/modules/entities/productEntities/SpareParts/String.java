package com.example.guitarApi.modules.entities.productEntities.SpareParts;

import com.example.guitarApi.modules.entities.productEntities.GuitarType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class String {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Company")
    private String company;
    @Column(name = "StringType")
    private GuitarType guitarType;
    @Column(name = "length")
    private double length;
    @Column(name = "Material")
    private String material;
    @Column(name = "Price")
    private double price;
    @Column(name = "Description")
    private String description;
}
