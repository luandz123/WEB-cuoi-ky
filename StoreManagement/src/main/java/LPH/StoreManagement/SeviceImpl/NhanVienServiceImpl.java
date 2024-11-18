package LPH.StoreManagement.SeviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import LPH.StoreManagement.Model.NhanVien;
import LPH.StoreManagement.Repository.NhanVienRepository;
import LPH.StoreManagement.Service.NhanVienService;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public NhanVien createNhanVien(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    @Override
    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }

    @Override
    public NhanVien getNhanVienById(Long id) {
        return nhanVienRepository.findById(id).orElseThrow(() -> new RuntimeException("NhanVien not found with id: " + id));
    }

    @Override
    public NhanVien updateNhanVien(Long id, NhanVien nhanVienDetails) {
        NhanVien nhanVien = getNhanVienById(id);
        nhanVien.setEmail(nhanVienDetails.getEmail());
        nhanVien.setNhomNguoiSuDung(nhanVienDetails.getNhomNguoiSuDung());
        nhanVien.setTenNhanVien(nhanVienDetails.getTenNhanVien());
        nhanVien.setTrangThai(nhanVienDetails.getTrangThai());
        return nhanVienRepository.save(nhanVien);
    }

    @Override
    public void deleteNhanVien(Long id) {
        NhanVien nhanVien = getNhanVienById(id);
        nhanVienRepository.delete(nhanVien);
    }
}
