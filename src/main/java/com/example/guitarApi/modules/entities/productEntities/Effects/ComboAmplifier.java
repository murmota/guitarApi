package com.example.guitarApi.modules.entities.productEntities.Effects;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Data
@Table(name = "ComboAmplifier", schema = "public", catalog = "postgres")
public class ComboAmplifier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "Name")
    public String name;
    @Column(name = "Company")
    private String company;
    @Column(name = "Watt")
    private double watt;
    @Column(name = "Weight")
    private double weight;
    @Column(name = "Price")
    private double price;
    @Column(name = "Description")
    private String description;


}
