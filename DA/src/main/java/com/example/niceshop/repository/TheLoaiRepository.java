package com.example.niceshop.repository;



import com.example.niceshop.entity.TheLoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TheLoaiRepository extends JpaRepository<TheLoai, UUID> {
}
