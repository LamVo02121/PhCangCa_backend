package com.example.PhCangCa.entity;
import jakarta.persistence.*;
@Entity
@Table(name="phts_dm_loaitau")
public class Loaitau {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String maLT;

        @Column(nullable = false, length=50 )
        private String tenLT;
        private String taoUser;
        private String taoNgay;
        private String capnhatUser;
        private String xoaUser;
        private String xoaNgay;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getMaLT() {
            return maLT;
        }

        public void setMaLT(String maLT) {
            this.maLT = maLT;
        }

        public String getTenLT() {
            return tenLT;
        }

        public void setTenLT(String tenLT) {
            this.tenLT = tenLT;
        }

        public String getTaoUser() {
            return taoUser;
        }

        public void setTaoUser(String taoUser) {
            this.taoUser = taoUser;
        }

        public String getTaoNgay() {
            return taoNgay;
        }

        public void setTaoNgay(String taoNgay) {
            this.taoNgay = taoNgay;
        }

        public String getCapnhatUser() {
            return capnhatUser;
        }

        public void setCapnhatUser(String capnhatUser) {
            this.capnhatUser = capnhatUser;
        }

        public String getXoaUser() {
            return xoaUser;
        }

        public void setXoaUser(String xoaUser) {
            this.xoaUser = xoaUser;
        }

        public String getXoaNgay() {
            return xoaNgay;
        }

        public void setXoaNgay(String xoaNgay) {
            this.xoaNgay = xoaNgay;
        }
}
