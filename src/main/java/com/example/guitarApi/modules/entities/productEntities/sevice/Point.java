package com.example.guitarApi.modules.entities.productEntities.sevice;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Point", schema = "public", catalog = "postgres")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Address")
    private String address;
    @Column(name = "isReady")
    private boolean isReady;
    @Column(name = "Employe")
    private int employeQuantity;
    @Column(name = "PhoneNumber")
    private String phoneNumber;
}
