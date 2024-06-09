package com.example.niceshop.service;




import com.example.niceshop.entity.TheLoai;

import java.util.List;
import java.util.UUID;

public interface TheLoaiService {
    List<TheLoai> getAllTheLoai();
    TheLoai detailTheLoai(UUID id);
    void deleteTheLoai(UUID id);
    void addTheLoai(TheLoai theLoai);
    void updateTheLoai(TheLoai theLoai);
}
