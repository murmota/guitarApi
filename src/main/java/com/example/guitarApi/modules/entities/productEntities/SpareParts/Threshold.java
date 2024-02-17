package com.example.guitarApi.modules.entities.productEntities.SpareParts;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Threshold {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "company")
    private String company;
    @Column(name = "Price")
    private double price;
    @Column(name = "Description")
    private String description;

}
