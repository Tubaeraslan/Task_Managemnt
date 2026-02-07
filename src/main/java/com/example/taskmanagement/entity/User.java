package com.example.taskmanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User extends BaseAuditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
}
