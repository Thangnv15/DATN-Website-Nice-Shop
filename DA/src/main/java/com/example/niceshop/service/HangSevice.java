package com.example.niceshop.service;

import com.example.niceshop.entity.*;
import com.example.niceshop.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HangSevice {
    @Autowired
    private HangDAO dao;

    public List<Hang> getAll() {
        return dao.findAll();
    }

    public Hang add(Hang hang) {
        return dao.save(hang);

    }

    public Hang update(UUID id, Hang hang) {
        if (id != null) {
            Hang update = dao.findById(id).orElse(null);
            if (update != null) {
                BeanUtils.copyProperties(hang, update);
                dao.save(update);
            }
        }
        return null;
    }



    public Boolean delete(UUID id) {
        if (id != null) {
            Hang hang = dao.findById(id).orElse(null);
            if (hang != null) {
                dao.delete(hang);
                return true;
            }
        }
        return false;
    }


    public Hang findById(UUID id) {
        return dao.findById(id).orElse(null);
    }
}
