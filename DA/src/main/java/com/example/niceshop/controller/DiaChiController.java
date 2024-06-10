package com.example.niceshop.controller;

import com.example.niceshop.service.DiaChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.niceshop.entity.DiaChi;


import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/diachi")
public class DiaChiController {
    @Autowired
    DiaChiService service;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}/taikhoan")
    public ResponseEntity<?> getAllById(@PathVariable("id")UUID idac){
        return ResponseEntity.ok(service.getAdressForAccount(idac));
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody DiaChi diaChi){
        System.out.println(diaChi.getChitiet());
        return ResponseEntity.ok(service.add(diaChi));
    }
    @DeleteMapping("/delete/{iddiachi}")
    public ResponseEntity<?> delete(@PathVariable("iddiachi") UUID iddiachi){
        return ResponseEntity.ok(service.delete(iddiachi));
    }
}
