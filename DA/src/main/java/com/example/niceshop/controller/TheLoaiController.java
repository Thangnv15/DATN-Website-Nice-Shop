package com.example.niceshop.controller;






import com.example.niceshop.entity.TheLoai;
import com.example.niceshop.service.TheLoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/the-loai")
public class TheLoaiController {

    @Autowired
    private TheLoaiService theLoaiService;


    @GetMapping("/hien-thi")
    private ResponseEntity<?> hienThiDanhSach() {

        return ResponseEntity.ok(this.theLoaiService.getAllTheLoai());
    }

    @RequestMapping(value = "/delete/{id}", method =  RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") UUID id) {
        theLoaiService.deleteTheLoai(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value ="/add", method =  RequestMethod.POST)
    public ResponseEntity<?> addChatLieu(@ModelAttribute("cl") TheLoai theLoai, BindingResult result, Model model) {

        theLoaiService.addTheLoai(theLoai);
        return ResponseEntity.ok().build();
    }


    @RequestMapping(value ="/update/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<?> update(@ModelAttribute TheLoai theLoai){
        theLoaiService.updateTheLoai(theLoai);
        return ResponseEntity.ok().build();
    }
}
