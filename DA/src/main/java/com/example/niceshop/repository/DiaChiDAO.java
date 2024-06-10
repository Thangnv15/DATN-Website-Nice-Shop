package com.example.niceshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.niceshop.entity.DiaChi;

import java.util.UUID;

public interface DiaChiDAO extends JpaRepository<DiaChi, UUID> {
}
