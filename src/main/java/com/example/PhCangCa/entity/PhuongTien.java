package com.example.PhCangCa.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cgca_phuongtien")
public class PhuongTien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID_PhuongTien")
    private int id;

    @Column(name = "id_LT")
    private int id_LT;

    @Column(name = "SoHieuPhuongTien")
    private String soHieuPT;

    @Column(name = "TenPhuongTien")
    private String tenPT;

    @Column(name = "CongSuat")
    private String congSuat;

    @Column(name = "TrongTai")
    private String trongTai;

    @Column(name = "SucChua")
    private String sucChua;

    @Column(name = "is_active")
    private int isActive;
    @Column(name = "is_delete")
    private int isDelete;
    @Column(length = 50, name = "create_user")
    private String createUser;
    @Column(length = 50, name = "create_username")
    private String createUsername;
    @Column(name = "create_date")
    private String createDate;
    @Column(name = "update_date")
    private String updateDate;
    @Column(length = 50, name = "update_user")
    private String updateUser;
    @Column(length = 50, name = "update_username")
    private String updateUsername;
    @Column(name = "delete_date")
    private Date deleteDate;
    @Column(length = 50, name = "delete_user")
    private String deleteUser;
    @Column(length = 50, name = "delete_username")
    private String deleteUsername;
    @Column(name = "ID_NV")
    private int idNV;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_LT() {
        return id_LT;
    }

    public void setId_LT(int id_LT) {
        this.id_LT = id_LT;
    }

    public String getSoHieuPT() {
        return soHieuPT;
    }

    public void setSoHieuPT(String soHieuPT) {
        this.soHieuPT = soHieuPT;
    }

    public String getTenPT() {
        return tenPT;
    }

    public void setTenPT(String tenPT) {
        this.tenPT = tenPT;
    }

    public String getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(String congSuat) {
        this.congSuat = congSuat;
    }

    public String getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(String trongTai) {
        this.trongTai = trongTai;
    }

    public String getSucChua() {
        return sucChua;
    }

    public void setSucChua(String sucChua) {
        this.sucChua = sucChua;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUsername() {
        return createUsername;
    }

    public void setCreateUsername(String createUsername) {
        this.createUsername = createUsername;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateUsername() {
        return updateUsername;
    }

    public void setUpdateUsername(String updateUsername) {
        this.updateUsername = updateUsername;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getDeleteUser() {
        return deleteUser;
    }

    public void setDeleteUser(String deleteUser) {
        this.deleteUser = deleteUser;
    }

    public String getDeleteUsername() {
        return deleteUsername;
    }

    public void setDeleteUsername(String deleteUsername) {
        this.deleteUsername = deleteUsername;
    }

    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }
}
