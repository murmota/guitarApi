package com.example.guitarApi.modules.entities.productEntities;

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
    private java.lang.String name;
    @Column(name = "Email")
    private java.lang.String email;
    @Column(name = "Password")
    private java.lang.String password;
    @Column(name = "PhoneNumber")
    private java.lang.String phoneNumber;
}
