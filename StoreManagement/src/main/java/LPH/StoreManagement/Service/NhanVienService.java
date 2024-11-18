package LPH.StoreManagement.Service;

import java.util.List;
import LPH.StoreManagement.Model.NhanVien;

public interface NhanVienService {
    NhanVien createNhanVien(NhanVien nhanVien);
    List<NhanVien> getAllNhanVien();
    NhanVien getNhanVienById(Long id);
    NhanVien updateNhanVien(Long id, NhanVien nhanVienDetails);
    void deleteNhanVien(Long id);
}
