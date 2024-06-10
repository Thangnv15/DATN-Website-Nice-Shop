package com.example.niceshop.services.impl;



import com.example.niceshop.entity.ChatLieu;
import com.example.niceshop.repository.ChatLieuDAO;
import com.example.niceshop.services.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChatLieuServiceImpl implements ChatLieuService {
    @Autowired
    private ChatLieuDAO chatLieuRepository;
    @Override
    public List<ChatLieu> getAllChatLieu() {
        return chatLieuRepository.findAll();
    }

    @Override
    public ChatLieu detailChatLieu(UUID id) {

        for (ChatLieu chatLieu : chatLieuRepository.findAll()) {
            if (chatLieu.getId().equals(id)) {
                return chatLieu;
            }
        }
        return null;
    }

    @Override
    public void deleteChatLieu(UUID id) {
   ChatLieu chatLieu = detailChatLieu(id);
   chatLieuRepository.delete(chatLieu);
    }

    @Override
    public void addChatLieu(ChatLieu chatLieu) {
     chatLieuRepository.save(chatLieu);

    }

    @Override
    public void updateChatLieu(ChatLieu chatLieu) {
chatLieuRepository.save(chatLieu);
    }
}
