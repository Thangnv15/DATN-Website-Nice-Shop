package com.example.niceshop.service;

import com.example.niceshop.repository.DiaChiDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.niceshop.entity.DiaChi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DiaChiService {
    @Autowired
    DiaChiDAO dao;

    public List<DiaChi> getAll() {
        return dao.findAll();
    }

    public List<DiaChi> getAdressForAccount(UUID idac) {
        List<DiaChi> list = new ArrayList<>();
        for (DiaChi diaChi : dao.findAll()) {
            if (diaChi.getTaiKhoan().getId().equals(idac)) {
                list.add(diaChi);
            }
        }
        return list;
    }

    public DiaChi add(DiaChi diaChi) {
        return dao.save(diaChi);
    }

    public DiaChi delete(UUID idDiaChi) {
        Optional<DiaChi> optional = dao.findById(idDiaChi);
        return optional.map(o -> {
            dao.delete(o);
            return o;
        }).orElse(null);
    }
}
