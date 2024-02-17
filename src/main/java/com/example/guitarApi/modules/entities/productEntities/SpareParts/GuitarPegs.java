package com.example.guitarApi.modules.entities.productEntities.SpareParts;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "GuitarPegs", schema = "public", catalog = "postgres")
public class GuitarPegs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Company")
    private String company;
    @Column(name = "Price")
    private double price;
    @Column(name = "Description")
    private String description;

}
