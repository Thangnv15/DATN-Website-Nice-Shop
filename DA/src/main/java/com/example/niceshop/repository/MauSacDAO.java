package com.example.niceshop.repository;

import com.example.niceshop.entity.MauSac;
import jakarta.persistence.PreRemove;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MauSacDAO extends JpaRepository<MauSac, UUID> {
}
