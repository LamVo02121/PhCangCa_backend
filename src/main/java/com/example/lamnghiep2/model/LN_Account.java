package com.example.lamnghiep2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ln_account")
public class LN_Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username",unique = true, nullable = false, length = 50)
    private String username;

    @Column(name = "email",unique = true, nullable = false, length = 50)
    private String email;

    @Column(name = "firstname", nullable = false, length = 25)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 25)
    private String lastname;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LN_Account() {
    }

    public LN_Account(int id, String username, String email, String firstname, String lastname, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }
}
