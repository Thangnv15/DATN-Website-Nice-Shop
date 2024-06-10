package com.example.niceshop.repository;

import com.example.niceshop.entity.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChiTietSanPhamDAO extends JpaRepository<ChiTietSanPham, UUID> {
}
