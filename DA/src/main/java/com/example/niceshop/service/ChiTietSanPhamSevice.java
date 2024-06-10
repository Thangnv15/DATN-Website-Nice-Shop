package com.example.niceshop.service;

import com.example.niceshop.entity.ChiTietSanPham;
import com.example.niceshop.entity.MauSac;
import com.example.niceshop.repository.ChiTietSanPhamDAO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSanPhamSevice {

    @Autowired
    private ChiTietSanPhamDAO chiTietSanPhamDAO;

    public List<ChiTietSanPham> getAll() {
        return chiTietSanPhamDAO.findAll();
    }

    public ChiTietSanPham add(ChiTietSanPham chiTietSanPham) {
        return chiTietSanPhamDAO.save(chiTietSanPham);

    }

    public ChiTietSanPham update(UUID id, ChiTietSanPham chiTietSanPham) {
        if (id != null) {
            ChiTietSanPham ctspupdate = chiTietSanPhamDAO.findById(id).orElse(null);
            if ( ctspupdate!= null) {
                BeanUtils.copyProperties(chiTietSanPham, ctspupdate);
                chiTietSanPhamDAO.save(chiTietSanPham);
            }
        }
        return null;
    }



    public Boolean delete(UUID id) {
        if (id != null) {
            ChiTietSanPham mauSac = chiTietSanPhamDAO.findById(id).orElse(null);
            if (mauSac != null) {
                chiTietSanPhamDAO.delete(mauSac);
                return true;
            }
        }
        return false;
    }


    public ChiTietSanPham findById(UUID id) {
        return chiTietSanPhamDAO.findById(id).orElse(null);
    }

}
