package LPH.StoreManagement.SeviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LPH.StoreManagement.Exception.ResourceNotFoundException;
import LPH.StoreManagement.Model.KhachHang;
import LPH.StoreManagement.Repository.KhachHangRepository;
import LPH.StoreManagement.Service.KhachHangService;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> layTatCaKhachHang() {
        return khachHangRepository.findAll();
    }

    @Override
    public Optional<KhachHang> layKhachHangTheoId(Long id) {
        return khachHangRepository.findById(id);
    }

    @Override
    public KhachHang taoKhachHang(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    @Override
    public KhachHang capNhatKhachHang(Long id, KhachHang chiTietKhachHang) {
        KhachHang khachHang = khachHangRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy khách hàng với id " + id));
        
        khachHang.setTenKhachHang(chiTietKhachHang.getTenKhachHang());
        khachHang.setDienThoai(chiTietKhachHang.getDienThoai());
        khachHang.setDiaChi(chiTietKhachHang.getDiaChi());
        khachHang.setLanCuoiMuaHang(chiTietKhachHang.getLanCuoiMuaHang());
        khachHang.setTongTienHang(chiTietKhachHang.getTongTienHang());
        khachHang.setTongNo(chiTietKhachHang.getTongNo());
        
        return khachHangRepository.save(khachHang);
    }

    @Override
    public void xoaKhachHang(Long id) {
        KhachHang khachHang = khachHangRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy khách hàng với id " + id));
        
        khachHangRepository.delete(khachHang);
    }
}

