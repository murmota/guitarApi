package com.example.guitarApi.modules.entities.productEntities.sevice;
import com.example.guitarApi.modules.entities.productEntities.UsersPackage.User;
import com.example.guitarApi.modules.entities.productEntities.products.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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