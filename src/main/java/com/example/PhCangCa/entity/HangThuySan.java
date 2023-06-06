package com.example.PhCangCa.entity;

import jakarta.persistence.*;

<<<<<<< HEAD
import java.io.Serializable;
=======
>>>>>>> 54d1054ee339fe8f758d474f01a8222a55ebf231
import java.util.Date;

@Entity
@Table(name = "cgca_dm_hangthuysan")
<<<<<<< HEAD
public class HangThuySan implements Serializable {
=======
public class HangThuySan {
>>>>>>> 54d1054ee339fe8f758d474f01a8222a55ebf231
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_Loai")
    private int id;
    @Column(nullable = false, length = 50, name = "TenLoai")
    private String tenLoai;
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
<<<<<<< HEAD
    private String updateDate;
=======
    private Date updateDate;
>>>>>>> 54d1054ee339fe8f758d474f01a8222a55ebf231
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

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
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

<<<<<<< HEAD
    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
=======
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
>>>>>>> 54d1054ee339fe8f758d474f01a8222a55ebf231
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

    @Override
    public String toString() {
        return "HangThuySan{" +
                "id=" + id +
                ", tenLoai='" + tenLoai + '\'' +
                ", isActive=" + isActive +
                ", isDelete=" + isDelete +
                ", createUser='" + createUser + '\'' +
                ", createUsername='" + createUsername + '\'' +
                ", createDate='" + createDate + '\'' +
                ", updateDate=" + updateDate +
                ", updateUser='" + updateUser + '\'' +
                ", updateUsername='" + updateUsername + '\'' +
                ", deleteDate=" + deleteDate +
                ", deleteUser='" + deleteUser + '\'' +
                ", deleteUsername='" + deleteUsername + '\'' +
                ", idNV=" + idNV +
                '}';
    }
}
