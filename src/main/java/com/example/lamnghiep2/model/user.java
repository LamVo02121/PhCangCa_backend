package com.example.lamnghiep2.model;

import jakarta.persistence.*;


@Entity
@Table(name = "user")
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "code", columnDefinition="VARCHAR(255)", nullable = false)
    private String code;

    @Column(name = "name", columnDefinition="VARCHAR(255)", nullable = false)
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "sex")
    private boolean sex;

    @Column(name = "dia_chi", columnDefinition = "VARCHAR(255)")
    private String dia_chi;

    @Column(name = "sdt", columnDefinition = "VARCHAR(12)", nullable = false)
    private String sdt;

    @Column(name = "cccd", columnDefinition = "VARCHAR(12)", nullable = false)
    private String cccd;


}
