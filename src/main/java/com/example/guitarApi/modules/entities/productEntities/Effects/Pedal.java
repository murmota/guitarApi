package com.example.guitarApi.modules.entities.productEntities.Effects;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Pedal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Company")
    private String company;
    @Column(name = "Weight")
    private double weight;
    @Column(name = "EffectType")
    private String effectType;
    @Column(name = "Price")
    private double price;
    @Column(name = "Description")
    private String description;
}
