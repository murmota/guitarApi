package com.example.guitarApi.modules.entities.productEntities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "Order", schema = "public", catalog = "postgres")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "UserId")
    private Long userId;
    @Column(name = "ProductId")
    private Long productId;
    @Column(name = "Status")
    private boolean status;
    @Column(name = "TotalPrice")
    private double totalPrice;
    @Column(name = "Date")
    private Date  date;
}
