package com.example.guitarApi.modules.entities.productEntities.sevice;

import com.example.guitarApi.modules.entities.productEntities.UsersPackage.User;
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
    @Column(name = "Status")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
