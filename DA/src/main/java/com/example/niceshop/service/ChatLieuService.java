package com.example.niceshop.service;

import com.example.niceshop.entity.*;
import com.example.niceshop.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class ChatLieuService {
    @Autowired
    private ChatLieuDAO chatLieuDAO;

    public List<ChatLieu> getAll() {
        return chatLieuDAO.findAll();
    }

    public ChatLieu add(ChatLieu chatLieu) {
        return chatLieuDAO.save(chatLieu);

    }

    public ChatLieu update(UUID id, ChatLieu chatLieu) {
        if (id != null) {
            ChatLieu Update = chatLieuDAO.findById(id).orElse(null);
            if (Update != null) {
                BeanUtils.copyProperties(chatLieu, Update);
                chatLieuDAO.save(Update);
            }
        }
        return null;
    }



    public Boolean delete(UUID id) {
        if (id != null) {
            ChatLieu chatLieu = chatLieuDAO.findById(id).orElse(null);
            if (chatLieu != null) {
                chatLieuDAO.delete(chatLieu);
                return true;
            }
        }
        return false;
    }


    public ChatLieu findById(UUID id) {
        return chatLieuDAO.findById(id).orElse(null);
    }
}
