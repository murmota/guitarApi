package com.example.guitarApi.modules.entities.productEntities.CareProducts;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CareCoating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Company")
    private String company;
    @Column(name = "Bulk")
    private String bulk;
    @Column(name = "Compound")
    private String compound;
    @Column(name = "Price")
    private String price;
    @Column(name = "Description")
    private String description;

}
