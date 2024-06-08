package com.example.niceshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "TaiKhoan")
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @Column(name = "username")
    private String username;
    @Column(name = "pass")
    private String pass;
    @Column(name = "hoten")
    private String hoten;
    @Column(name = "namsinh")
    private Date namsinh;
    @Column(name = "email")
    private String email;
    @Column(name = "sdt")
    private String sdt;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "created_date")
    private Date created_date;
    @Column(name = "update_date")
    private Date update_date;
    @Column(name = "is_deleted")
    private Boolean is_deleted;
    @JsonIgnore
    @OneToMany(mappedBy = "taiKhoan")
    List<DiaChi> listDiaChi;
    //    @JsonIgnore
//    @OneToMany(mappedBy = "id_GioiHang")
//    List<GioHang> listGioHang;
//    @JsonIgnore
//    @OneToMany(mappedBy = "id_HoaDon")
//    List<DatHang> listDatHang;
    @JsonIgnore
    @OneToMany(mappedBy = "taiKhoan", fetch = FetchType.LAZY)
    private List<VaiTroTK> vaiTroTKS;


}
