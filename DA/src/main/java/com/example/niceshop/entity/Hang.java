package com.example.niceshop.entity;

import jakarta.persistence.*;
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
@Table(name = "Hang")
public class Hang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id ;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;
    @CreationTimestamp
    @Column(name = "created_date")
    private Date ngayTao;

    @Column(name = "update_date")
    private Date ngayCapNhat;
}
