package com.example.niceshop.controller;

import com.example.niceshop.entity.ChiTietSanPham;
import com.example.niceshop.entity.MauSac;
import com.example.niceshop.service.ChiTietSanPhamSevice;
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
@RequestMapping("/api/ctsp")
public class ChiTietSanPhamContronller {

    @Autowired
    private ChiTietSanPhamSevice sevice;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        List<ChiTietSanPham> list = sevice.getAll();
        System.out.println(list);
        return ResponseEntity.ok(sevice.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ChiTietSanPham chiTietSanPham ){
        ChiTietSanPham ctsp = sevice.add(chiTietSanPham);
        return ResponseEntity.ok(ctsp);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        return ResponseEntity.ok(sevice.delete(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody ChiTietSanPham chiTietSanPham){
        ChiTietSanPham ctsp = sevice.update(id,chiTietSanPham);
        return ResponseEntity.ok(ctsp);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable UUID id){
        ChiTietSanPham ctsp = sevice.findById(id);
        return ResponseEntity.ok(ctsp);
    }
}
