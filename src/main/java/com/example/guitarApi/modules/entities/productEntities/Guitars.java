package com.example.guitarApi.modules.entities.productEntities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Guitars", schema = "public", catalog = "postgres")
public class Guitars implements IGuitar{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long ID;
    @Column(name = "Name")
    private String Name;
    @Column(name = "Company")
    private String Company;
    @Column(name = "Weight")
    private double Weight;
    @Column(name = "Color")
    private String Color;
    @Column(name = "StringQuantity")
    private int StringQuantity;
    @Column(name = "Price")
    private double Price;
    @Column(name = "Description")
    private String Description;
    @Column(name = "GuitarType")
    private GuitarType GuitarType;
}
