package com.example.niceshop.service;

import com.example.niceshop.entity.VaiTro;
import com.example.niceshop.repository.VaiTroDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaiTroService {
    @Autowired
    VaiTroDAO vaiTroDAO;
    public List<VaiTro> getAll(){
        return vaiTroDAO.findAll();
    }
}
