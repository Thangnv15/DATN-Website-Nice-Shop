package com.example.niceshop.entity;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "id_sanpham")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "id_size")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "id_mausac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "id_chatlieu")
    private ChatLieu chatLieu;

    @ManyToOne
    @JoinColumn(name = "id_xuatxu")
    private XuatXu xuatXu;

    @ManyToOne
    @JoinColumn(name = "id_theloai")
    private TheLoai theLoai;

    @ManyToOne
    @JoinColumn(name = "id_hang")
    private Hang hang;

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
