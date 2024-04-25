package com.example.guitarApi.models;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name ="Basket", schema = "public", catalog = "postgres")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}