package com.example.niceshop.repository;

import com.example.niceshop.entity.VaiTro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VaiTroDAO extends JpaRepository<VaiTro, UUID> {
}
