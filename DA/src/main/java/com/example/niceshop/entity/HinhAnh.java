package com.example.niceshop.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "Anh")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class HinhAnh {
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;


    @Column(name = "anh")
    private String anh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sanphamct",referencedColumnName = "id")
    private ChiTietSanPham  chiTietSanPham;


}
