package com.example.PhCangCa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cgca_cang")
public class CangCa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_CG")
    private int id;
    @Column(nullable = false, length = 255, name = "TenCang")
    private String tenCang;

    @Column(length = 255, name = "Loai")
    private String loai;
    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Description")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTenCang() {
        return tenCang;
    }

    public void setTenCang(String tenCang) {
        this.tenCang = tenCang;
    }


    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
