package com.example.niceshop.service;




import com.example.niceshop.entity.SanPham;
import com.example.niceshop.repository.SanPhamDAO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class SanPhamService {

    @Autowired
    private SanPhamDAO sanPhamDAO;

    public List<SanPham> getAll() {
        return sanPhamDAO.findAll();
    }

    public SanPham add(SanPham sanPham) {
        return sanPhamDAO.save(sanPham);

    }

    public SanPham update(UUID id, SanPham sanPham) {
        if (id != null) {
            SanPham sanPhamUpdate = sanPhamDAO.findById(id).orElse(null);
            if (sanPhamUpdate != null) {
                BeanUtils.copyProperties(sanPham, sanPhamUpdate);
                sanPhamDAO.save(sanPhamUpdate);
            }
        }
        return null;
    }



    public Boolean delete(UUID id) {
        if (id != null) {
            SanPham sanPham = sanPhamDAO.findById(id).orElse(null);
            if (sanPham != null) {
                sanPhamDAO.delete(sanPham);
                return true;
            }
        }
        return false;
    }


    public SanPham findById(UUID id) {
        return sanPhamDAO.findById(id).orElse(null);
    }

}
