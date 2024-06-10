package com.example.niceshop.repository;

import com.example.niceshop.entity.ChatLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping
public interface ChatLieuDAO extends JpaRepository<ChatLieu, UUID> {
}
