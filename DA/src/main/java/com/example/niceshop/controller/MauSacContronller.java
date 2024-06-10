package com.example.niceshop.controller;

import com.example.niceshop.entity.MauSac;
import com.example.niceshop.service.MauSacService;
import com.example.niceshop.service.TaiKhoanService;
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
@RequestMapping("/api/mausac")
public class MauSacContronller {

    @Autowired
    private MauSacService service;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        List<MauSac> list = service.getAll();
        System.out.println(list);
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody MauSac mauSac ){
        MauSac color = service.add(mauSac);
        return ResponseEntity.ok(color);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        return ResponseEntity.ok(service.delete(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody MauSac mauSac){
        MauSac color = service.update(id,mauSac);
        return ResponseEntity.ok(color);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable UUID id){
        MauSac color = service.findById(id);
        return ResponseEntity.ok(color);
    }
}
