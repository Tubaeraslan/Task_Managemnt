package com.example.taskmanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class Role extends BaseAuditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
