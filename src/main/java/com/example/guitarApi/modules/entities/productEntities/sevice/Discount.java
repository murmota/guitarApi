package com.example.guitarApi.modules.entities.productEntities.sevice;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name ="Discount", schema = "public", catalog = "postgres")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "discount")
    private int percent;

}
