package com.example.niceshop.controller;

import com.example.niceshop.entity.SanPham;
import com.example.niceshop.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sanpham")
public class SanPhamContronller {

    @Autowired
    private SanPhamService service;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        List<SanPham> list  = service.getAll();
        System.out.println(list);
        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody SanPham sanPham ){
        SanPham sp = service.add(sanPham);
        return ResponseEntity.ok(sp);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        return ResponseEntity.ok(service.delete(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody SanPham sanPham){
        SanPham sp = service.update(id,sanPham);
        return ResponseEntity.ok(sp);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable UUID id){
        SanPham sp = service.findById(id);
        return ResponseEntity.ok(sp);
    }
}
