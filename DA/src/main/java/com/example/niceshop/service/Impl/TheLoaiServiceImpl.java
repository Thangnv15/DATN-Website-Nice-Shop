package com.example.niceshop.service.Impl;




import com.example.niceshop.entity.TheLoai;
import com.example.niceshop.repository.TheLoaiRepository;
import com.example.niceshop.service.TheLoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TheLoaiServiceImpl implements TheLoaiService {
    @Autowired
    private TheLoaiRepository theLoaiRepository;
    @Override
    public List<TheLoai> getAllTheLoai() {
        return theLoaiRepository.findAll();
    }

    @Override
    public TheLoai detailTheLoai(UUID id) {

        for (TheLoai theLoai : theLoaiRepository.findAll()) {
            if (theLoai.getId().equals(id)) {
                return theLoai;
            }
        }
        return null;
    }

    @Override
    public void deleteTheLoai(UUID id) {
        TheLoai theLoai = detailTheLoai(id);
   theLoaiRepository.delete(theLoai);
    }

    @Override
    public void addTheLoai(TheLoai chatLieu) {
     theLoaiRepository.save(chatLieu);

    }

    @Override
    public void updateTheLoai(TheLoai chatLieu) {
theLoaiRepository.save(chatLieu);
    }
}
