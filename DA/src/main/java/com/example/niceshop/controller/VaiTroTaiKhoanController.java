package com.example.niceshop.controller;

import com.example.niceshop.entity.VaiTroTK;
import com.example.niceshop.service.VaiTroTaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/vaitrotaikhoan")
public class VaiTroTaiKhoanController {
    @Autowired
    VaiTroTaiKhoanService service;
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody VaiTroTK tk){
        return ResponseEntity.ok(service.add(tk));
    }

}
