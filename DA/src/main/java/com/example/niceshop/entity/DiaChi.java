package com.example.niceshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "DiaChi")
public class DiaChi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @ManyToOne
    @JoinColumn(name = "id_taikhoan")
    private TaiKhoan taiKhoan;

    @Column(name = "phuong")
    private String phuong;

    @Column(name = "quan")
    private String quan;

    @Column(name = "thanhpho")
    private String thanhpho;

    @Column(name = "chitiet")
    private String chitiet;


}
