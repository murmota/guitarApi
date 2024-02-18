package com.example.guitarApi.modules.entities.productEntities.SpareParts;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Bridge", schema = "public", catalog = "postgres")
public class Bridge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Company")
    private String company;
    @Column(name = "Material")
    private String material;
    @Column(name = "Price")
    private double price;
    @Column(name = "Description")
    private String description;
}
