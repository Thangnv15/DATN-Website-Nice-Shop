package com.example.niceshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.*;


import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "VaiTro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VaiTro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "ten")
    private String ten;
    @JsonIgnore
    @OneToMany(mappedBy = "vaiTro", fetch = FetchType.LAZY)
    private List<VaiTroTK> listVaiTroTK;
}
