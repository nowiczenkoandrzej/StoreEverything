package com.an.storeeverything.models;

import jakarta.persistence.*;

@Entity
public class RolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;
}
