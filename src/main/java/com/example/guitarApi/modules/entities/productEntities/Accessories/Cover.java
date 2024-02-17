package com.example.guitarApi.modules.entities.productEntities.Accessories;

import com.example.guitarApi.modules.entities.productEntities.GuitarType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Company")
    private String company;
    @Column(name = "Price")
    private double price;
    @Column(name = "Description")
    private String description;
    @Column(name = "Type")
    private GuitarType guitarType;
    @Column(name = "Material")
    private String material;
    @Column(name = "ZipperType")
    private String zipperType;
    @Column(name = "Weight")
    private double weight;

}
