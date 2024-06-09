package com.example.niceshop.service;




import com.example.niceshop.entity.HinhAnh;

import java.util.List;
import java.util.UUID;

public interface HinhAnhService {
    List<HinhAnh> getAllAnh();
    HinhAnh detailAnh(UUID id);
    void deleteAnh(UUID id);
    void addAnh(HinhAnh hinhAnh);
    void updateAnh(HinhAnh hinhAnh);
}
