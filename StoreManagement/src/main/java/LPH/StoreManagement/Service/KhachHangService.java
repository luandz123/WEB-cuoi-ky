package LPH.StoreManagement.Service;

import java.util.List;
import java.util.Optional;

import LPH.StoreManagement.Model.KhachHang;

public interface KhachHangService {

    List<KhachHang> layTatCaKhachHang();

    Optional<KhachHang> layKhachHangTheoId(Long id);

    KhachHang taoKhachHang(KhachHang khachHang);

    KhachHang capNhatKhachHang(Long id, KhachHang chiTietKhachHang);

    void xoaKhachHang(Long id);
}

