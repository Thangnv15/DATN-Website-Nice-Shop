package com.example.niceshop.service;

import com.example.niceshop.entity.*;
import com.example.niceshop.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SizeService {
    @Autowired
    private SizeDAO dao;

    public List<Size> getAll() {
        return dao.findAll();
    }

    public Size add(Size size) {
        return dao.save(size);

    }

    public Size update(UUID id, Size size) {
        if (id != null) {
            Size update = dao.findById(id).orElse(null);
            if (update != null) {
                BeanUtils.copyProperties(size, update);
                dao.save(update);
            }
        }
        return null;
    }



    public Boolean delete(UUID id) {
        if (id != null) {
            Size size = dao.findById(id).orElse(null);
            if (size != null) {
                dao.delete(size);
                return true;
            }
        }
        return false;
    }


    public Size findById(UUID id) {
        return dao.findById(id).orElse(null);
    }
}
