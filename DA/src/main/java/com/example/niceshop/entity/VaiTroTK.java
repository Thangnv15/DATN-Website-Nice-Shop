
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
@Table(name = "VaiTroTaiKhoan")
public class VaiTroTK {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_taikhoan")
    private TaiKhoan taiKhoan;
    @ManyToOne
    @JoinColumn(name = "id_vaitro")
    private VaiTro vaiTro;

}
