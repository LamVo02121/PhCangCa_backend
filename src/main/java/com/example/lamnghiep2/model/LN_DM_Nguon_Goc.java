package com.example.lamnghiep2.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "LN_DM_Nguon_Goc")
public class LN_DM_Nguon_Goc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code",length = 255, nullable = false)
    private String code;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "is_active", nullable = true)
    private boolean is_active;
    @Column(name = "is_delete", nullable = true)
    private boolean is_delete;

    @Column(name = "create_user", length = 255)
    private String create_user;

    @Column(name = "create_username", length = 255)
    private String create_username;

    @Column(name = "update_date", columnDefinition = "Timestamp DEFAULT CURRENT_TIMESTAMP")
//    @CreationTimestamp
    private Timestamp update_date;

    @Column(name = "update_user", length = 255)
    private String update_user;

    @Column(name = "update_username", length = 255)
    private String update_username;

    @Column(name = "delete_user", length = 255)
    private String delete_user;

    @Column(name = "delete_username", length = 255)
    private String delete_username;

    @Column(name = "uid", length = 50)
    private String uid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }

    public String getCreate_user() {
        return create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    public String getCreate_username() {
        return create_username;
    }

    public void setCreate_username(String create_username) {
        this.create_username = create_username;
    }

    public Timestamp getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Timestamp update_date) {
        this.update_date = update_date;
    }

    public String getUpdate_user() {
        return update_user;
    }

    public void setUpdate_user(String update_user) {
        this.update_user = update_user;
    }

    public String getUpdate_username() {
        return update_username;
    }

    public void setUpdate_username(String update_username) {
        this.update_username = update_username;
    }

    public String getDelete_user() {
        return delete_user;
    }

    public void setDelete_user(String delete_user) {
        this.delete_user = delete_user;
    }

    public String getDelete_username() {
        return delete_username;
    }

    public void setDelete_username(String delete_username) {
        this.delete_username = delete_username;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
