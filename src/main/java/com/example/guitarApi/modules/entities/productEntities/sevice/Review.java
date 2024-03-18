package com.example.guitarApi.modules.entities.productEntities.sevice;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "Review", schema = "public", catalog = "postgres")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "UserId")
    private Long userId;
    @Column(name = "ProductId")
    private Long productId;
    @Column(name = "Content")
    private String content;
    @Column(name = "Mark")
    private int mark;
    @Column(name = "Date")
    private Date date;
}
