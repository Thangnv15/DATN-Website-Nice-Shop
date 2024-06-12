package com.example.niceshop.repository;

import com.example.niceshop.entity.XuatXu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface XuatXuDAO extends JpaRepository<XuatXu, UUID> {
}
