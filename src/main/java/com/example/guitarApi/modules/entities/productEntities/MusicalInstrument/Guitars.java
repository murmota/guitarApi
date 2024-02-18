package com.example.guitarApi.modules.entities.productEntities.MusicalInstrument;

import com.example.guitarApi.modules.entities.productEntities.GuitarType;
import com.example.guitarApi.modules.entities.productEntities.SpareParts.Strings;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Guitars", schema = "public", catalog = "postgres")
public class Guitars implements IGuitar{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
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
    @Enumerated(EnumType.STRING)
    @Column(name = "GuitarType")
    private GuitarType guitarType;
}
