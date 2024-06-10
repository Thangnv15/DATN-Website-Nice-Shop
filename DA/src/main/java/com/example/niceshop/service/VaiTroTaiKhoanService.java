package com.example.niceshop.service;

import com.example.niceshop.repository.VaiTroDAO;
import com.example.niceshop.repository.VaiTroTaiKhoanDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.niceshop.entity.VaiTroTK;
import java.util.List;

@Service
public class VaiTroTaiKhoanService {
    @Autowired
    VaiTroTaiKhoanDAO vaiTroTaiKhoanDAO;
    public List<VaiTroTK> getAll(){
        return vaiTroTaiKhoanDAO.findAll();
    }
    public VaiTroTK add(VaiTroTK vaiTroTK){
        return vaiTroTaiKhoanDAO.save(vaiTroTK);
    }
}
