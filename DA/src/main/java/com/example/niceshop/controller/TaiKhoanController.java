package com.example.niceshop.controller;

import com.example.niceshop.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.niceshop.entity.*;

import java.util.List;

//@CrossOrigin("*")
@RestController
@RequestMapping("/api/taikhoan")
public class TaiKhoanController {
    final
    TaiKhoanService service;

    public TaiKhoanController(TaiKhoanService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {

        for (TaiKhoan list : service.getAll()) {
            List<VaiTroTK> vaiTroTKS = list.getVaiTroTKS();
//            System.out.println("get all" + service.getAll());
            for (VaiTroTK vttk : vaiTroTKS) {
                String tenVaiTro = vttk.getVaiTro().getTen();
                System.out.println(tenVaiTro);
            }
        }
        return ResponseEntity.ok(this.service.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody TaiKhoan tk) {
        return ResponseEntity.ok(service.add(tk));
    }

}
