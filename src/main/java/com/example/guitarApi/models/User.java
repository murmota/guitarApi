package com.example.guitarApi.models;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "User", schema = "public", catalog = "postgres")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "UserName")
    private String userName;
    @Column(name = "Email")
    private String email;
    @Column(name = "Password")
    private String password;
    @Column(name = "Phone_Number")
    private String phoneNumber;
    @Column(name = "role")
    private String role;
}