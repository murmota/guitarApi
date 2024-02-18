package com.example.guitarApi.modules.entities.productEntities.Accessories;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Metronome", schema = "public", catalog = "postgres")
public class Metronome {
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
    @Column(name = "Weight")
    private double weight;
}
