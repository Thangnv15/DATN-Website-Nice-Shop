package com.example.niceshop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ChiTietSanPham")
public class ChiTietSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "giaban")
    private BigDecimal giaBan;

    @Column(name = "gianhap")
    private BigDecimal giaNhap;

    @Column(name = "soluongton")
    private Integer soLuongTon;

    @Column(name = "mota")
    private String mota;

    @Column(name = "trangthai")
    private Boolean trangThai;

    public String trangThai() {
        if (trangThai != null && trangThai) {
            return "Còn dùng";
        }
        return "Không còn dùng";
    }
}
