package com.example.niceshop.service;




import com.example.niceshop.entity.ChatLieu;

import java.util.List;
import java.util.UUID;

public interface ChatLieuService {
    List<ChatLieu> getAllChatLieu();
    ChatLieu detailChatLieu(UUID id);
    void deleteChatLieu(UUID id);
    void addChatLieu(ChatLieu chatLieu);
    void updateChatLieu(ChatLieu chatLieu);
}
