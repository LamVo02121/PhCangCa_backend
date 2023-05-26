package com.mycompany.csud;

import javax.persistence.*;

@Entity
@Table(name = "cs_uong_duong_giong_ts")
public class Csud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 45, name = "ten_cs")
    private String tenCoSo;

    @Column(length = 15, nullable = false, name = "loai_giong_uong")
    private String loaiGiongUong;

    @Column(length = 45, nullable = false, name = "ngay_uong")
    private String ngayUong;

    @Column(length = 45, nullable = false, name = "so_luong")
    private String soLuong;

    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenCoSo() {
        return tenCoSo;
    }

    public void setTenCoSo(String tenCoSo) {
        this.tenCoSo = tenCoSo;
    }

    public String getLoaiGiongUong() {
        return loaiGiongUong;
    }

    public void setLoaiGiongUong(String loaiGiongUong) {
        this.loaiGiongUong = loaiGiongUong;
    }

    public String getNgayUong() {
        return ngayUong;
    }

    public void setNgayUong(String ngayUong) {
        this.ngayUong = ngayUong;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", tenCoSo='" + getTenCoSo() + '\'' +
                ", loaiGiongUong='" + getLoaiGiongUong() + '\'' +
                ", ngayUong='" + getNgayUong() + '\'' +
                ", soLuong='" + getSoLuong() + '\'' +
                '}';
    }



}
