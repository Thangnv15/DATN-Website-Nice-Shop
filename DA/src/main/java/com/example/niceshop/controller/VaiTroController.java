package com.example.niceshop.controller;

import com.example.niceshop.entity.VaiTro;
import com.example.niceshop.entity.TaiKhoan;
import com.example.niceshop.entity.VaiTroTK;
import com.example.niceshop.service.VaiTroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/vaitro")
public class VaiTroController {
    @Autowired
    VaiTroService service;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<VaiTro> list = service.getAll();
        for (VaiTro vaiTro : list) {
            System.out.println("Vai Trò:" + vaiTro.getTen());
            List<VaiTroTK> vaiTroTKs = vaiTro.getListVaiTroTK();
            for (VaiTroTK vaiTroTK : vaiTroTKs) {
                TaiKhoan taiKhoan = vaiTroTK.getTaiKhoan();
                System.out.println("  Tài Khoản ID:" + taiKhoan.getId());
                System.out.println("  Tài Khoản user name:" + taiKhoan.getUsername());
                System.out.println("  Tài Khoản Email:" + taiKhoan.getEmail());
                System.out.println("  Tài Khoản SDT:" + taiKhoan.getSdt());
            }
        }
        return ResponseEntity.ok(service.getAll());
    }
}
