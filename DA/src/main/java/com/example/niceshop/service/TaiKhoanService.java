package com.example.niceshop.service;

import com.example.niceshop.repository.TaiKhoanDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.niceshop.entity.TaiKhoan;

import java.util.List;

@Service
public class TaiKhoanService {
    final
    TaiKhoanDAO taiKhoanDAO;

    public TaiKhoanService(TaiKhoanDAO taiKhoanDAO) {
        this.taiKhoanDAO = taiKhoanDAO;
    }

    public List<TaiKhoan> getAll() {
        return this.taiKhoanDAO.findAll();
    }

    public TaiKhoan add(TaiKhoan tk) {
        return taiKhoanDAO.save(tk);
    }
}
