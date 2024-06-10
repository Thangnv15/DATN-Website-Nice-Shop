package com.example.niceshop.service;

import com.example.niceshop.entity.MauSac;
import com.example.niceshop.repository.MauSacDAO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MauSacService {

    @Autowired
    private MauSacDAO mauSacDAO;

    public List<MauSac> getAll() {
        return mauSacDAO.findAll();
    }

    public MauSac add(MauSac mauSac) {
        return mauSacDAO.save(mauSac);

    }

    public MauSac update(UUID id, MauSac mauSac) {
        if (id != null) {
            MauSac mauSacUpdate = mauSacDAO.findById(id).orElse(null);
            if (mauSacUpdate != null) {
                BeanUtils.copyProperties(mauSac, mauSacUpdate);
                mauSacDAO.save(mauSacUpdate);
            }
        }
        return null;
    }



    public Boolean delete(UUID id) {
        if (id != null) {
            MauSac mauSac = mauSacDAO.findById(id).orElse(null);
            if (mauSac != null) {
                mauSacDAO.delete(mauSac);
                return true;
            }
        }
        return false;
    }


    public MauSac findById(UUID id) {
        return mauSacDAO.findById(id).orElse(null);
    }


}
