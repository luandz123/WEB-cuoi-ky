package LPH.StoreManagement.Service;

import java.util.List;
import java.util.Optional;

import LPH.StoreManagement.Model.SanPham;


public interface SanPhamService {

    List<SanPham> laySanPhamTheoTen(String tenSanPham);
    List<SanPham> laySanPhamTheogia(Double giaMin , Double giaMax);

    List<SanPham> layTatCaSanPham();

    Optional<SanPham> laySanPhamTheoId(Long id);

    SanPham taoSanPham(SanPham sanPham);

    SanPham capNhatSanPham(Long id, SanPham chiTietSanPham);

    void xoaSanPham(Long id);
}

