package com.example.niceshop.controller;



import com.example.niceshop.entity.ChatLieu;
import com.example.niceshop.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@Controller
@RequestMapping("/api/chat-lieu")
public class ChatLieuController {

    @Autowired
    private ChatLieuService chatLieuService;


    @GetMapping("/hien-thi")
    private ResponseEntity<?> hienThiDanhSach() {

         return ResponseEntity.ok(this.chatLieuService.getAllChatLieu());
    }

    @RequestMapping(value = "/delete/{id}", method =  RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") UUID id) {
        chatLieuService.deleteChatLieu(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value ="/add", method =  RequestMethod.POST)
    public ResponseEntity<?> addChatLieu(@ModelAttribute("cl") ChatLieu chatLieu, BindingResult result, Model model) {

        chatLieuService.addChatLieu(chatLieu);
        return ResponseEntity.ok().build();
    }


    @RequestMapping(value ="/update/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<?> update(@ModelAttribute ChatLieu chatLieu){
        chatLieuService.updateChatLieu(chatLieu);
        return ResponseEntity.ok().build();
    }
}
