package com.example.guitarApi.modules.entities.productEntities.UsersPackage;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "User", schema = "public", catalog = "postgres")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Email")
    private String email;
    @Column(name = "Password")
    private String password;
    @Column(name = "PhoneNumber")
    private String phoneNumber;
}
