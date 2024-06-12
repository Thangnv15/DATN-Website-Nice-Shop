package com.example.niceshop.service;

import com.example.niceshop.entity.*;
import com.example.niceshop.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TheLoaiService {
    @Autowired
    private TheLoaiDAO dao;

    public List<TheLoai> getAll() {
        return dao.findAll();
    }

    public TheLoai add(TheLoai theLoai) {
        return dao.save(theLoai);

    }

    public TheLoai update(UUID id, TheLoai theLoai) {
        if (id != null) {
            TheLoai update = dao.findById(id).orElse(null);
            if (update != null) {
                BeanUtils.copyProperties(theLoai, update);
                dao.save(update);
            }
        }
        return null;
    }



    public Boolean delete(UUID id) {
        if (id != null) {
            TheLoai theLoai = dao.findById(id).orElse(null);
            if (theLoai != null) {
                dao.delete(theLoai);
                return true;
            }
        }
        return false;
    }


    public TheLoai findById(UUID id) {
        return dao.findById(id).orElse(null);
    }
}
