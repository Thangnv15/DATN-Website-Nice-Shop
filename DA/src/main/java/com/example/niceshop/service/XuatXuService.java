package com.example.niceshop.service;

import com.example.niceshop.entity.*;
import com.example.niceshop.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class XuatXuService {
    @Autowired
    private XuatXuDAO dao;

    public List<XuatXu> getAll() {
        return dao.findAll();
    }

    public XuatXu add(XuatXu xuatXu) {
        return dao.save(xuatXu);

    }

    public XuatXu update(UUID id, XuatXu xuatXu) {
        if (id != null) {
            XuatXu update = dao.findById(id).orElse(null);
            if (update != null) {
                BeanUtils.copyProperties(xuatXu, update);
                dao.save(update);
            }
        }
        return null;
    }



    public Boolean delete(UUID id) {
        if (id != null) {
            XuatXu xuatXu = dao.findById(id).orElse(null);
            if (xuatXu != null) {
                dao.delete(xuatXu);
                return true;
            }
        }
        return false;
    }


    public XuatXu findById(UUID id) {
        return dao.findById(id).orElse(null);
    }
}
