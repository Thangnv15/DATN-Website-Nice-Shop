package com.example.niceshop.service.Impl;



import com.example.niceshop.entity.HinhAnh;
import com.example.niceshop.repository.HinhAnhRepository;
import com.example.niceshop.service.HinhAnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HinhAnhServiceImpl implements HinhAnhService {
    @Autowired
    private HinhAnhRepository hinhAnhRepository;

    @Override
    public List<HinhAnh> getAllAnh() {
        return hinhAnhRepository.findAll();
    }

    @Override
    public HinhAnh detailAnh(UUID id) {
        for (HinhAnh anh : hinhAnhRepository.findAll()) {
            if (anh.getId().equals(id)) {
                return anh;
            }
        }

        return null;
    }

    @Override
    public void deleteAnh(UUID id) {
        HinhAnh anh = detailAnh(id);
        hinhAnhRepository.delete(anh);
    }

    @Override
    public void addAnh(HinhAnh anh) {
        hinhAnhRepository.save(anh);
    }

    @Override
    public void updateAnh(HinhAnh anh) {
hinhAnhRepository.save(anh);
    }
}
