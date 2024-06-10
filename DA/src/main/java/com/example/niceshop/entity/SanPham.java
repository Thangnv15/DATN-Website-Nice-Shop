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
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "SanPham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id ;

    @Column(name = "masp")
    private String ma;

    @Column(name = "ten")
    private String ten;
    @CreationTimestamp
    @Column(name = "created_date")
    private Date ngayTao;
    @CreationTimestamp
    @Column(name = "update_date")
    private Date ngayCapNhat;

    @Column(name = "trangthai")
    private Boolean trangThai;

    public String trangThai() {
        if (trangThai != null && trangThai) {
            return "Còn dùng";
        }
        return "Không còn dùng";
    }
}
