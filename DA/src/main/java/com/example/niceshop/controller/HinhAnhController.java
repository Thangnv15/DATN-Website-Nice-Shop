package com.example.niceshop.controller;






import com.example.niceshop.entity.HinhAnh;
import com.example.niceshop.service.HinhAnhService;
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

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/hinh-anh")
public class HinhAnhController {

    @Autowired
    private HinhAnhService hinhAnhService;


    @GetMapping("/hien-thi")
    private ResponseEntity<?> hienThiDanhSach() {

        return ResponseEntity.ok(this.hinhAnhService.getAllAnh());
    }

    @RequestMapping(value = "/delete/{id}", method =  RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") UUID id) {
        hinhAnhService.deleteAnh(id);
        return ResponseEntity.ok().build();
    }


    @RequestMapping(value ="/add", method =  RequestMethod.POST)
    public ResponseEntity<?> addChatLieu(@ModelAttribute("ha") HinhAnh hinhAnh, BindingResult result, Model model) {

        hinhAnhService.addAnh(hinhAnh);
        return ResponseEntity.ok().build();
    }


    @RequestMapping(value ="/update/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<?> update(@ModelAttribute HinhAnh hinhAnh){
        hinhAnhService.updateAnh(hinhAnh);
        return ResponseEntity.ok().build();
    }
}
