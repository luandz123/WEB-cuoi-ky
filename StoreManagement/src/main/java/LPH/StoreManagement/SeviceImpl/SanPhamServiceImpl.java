package LPH.StoreManagement.SeviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LPH.StoreManagement.Exception.ResourceNotFoundException;
import LPH.StoreManagement.Model.SanPham;
import LPH.StoreManagement.Repository.SanPhamRepository;
import LPH.StoreManagement.Service.SanPhamService;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> laySanPhamTheoTen(String tenSanPham) {
        return sanPhamRepository.findByTenSanPham(tenSanPham);
    }
    @Override
        public List<SanPham> laySanPhamTheogia(Double giaMin , Double giaMax){
            return sanPhamRepository.findByGiaBanBetween(giaMin, giaMax);
        }

    @Override
    public List<SanPham> layTatCaSanPham() {
        return sanPhamRepository.findAll();
    }

    @Override
    public Optional<SanPham> laySanPhamTheoId(Long id) {
        return sanPhamRepository.findById(id);
    }

    @Override
    public SanPham taoSanPham(SanPham sanPham) {
        return sanPhamRepository.save(sanPham);
    }

    @Override
    public SanPham capNhatSanPham(Long id, SanPham chiTietSanPham) {
        SanPham sanPham = sanPhamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy sản phẩm với id " + id));

        sanPham.setTenSanPham(chiTietSanPham.getTenSanPham());
        sanPham.setSoLuong(chiTietSanPham.getSoLuong());
        sanPham.setGiaBan(chiTietSanPham.getGiaBan());
        sanPham.setDanhMuc(chiTietSanPham.getDanhMuc());
        sanPham.setNhaSanXuat(chiTietSanPham.getNhaSanXuat());

        return sanPhamRepository.save(sanPham);
    }

    @Override
    public void xoaSanPham(Long id) {
        SanPham sanPham = sanPhamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy sản phẩm với id " + id));
        sanPhamRepository.delete(sanPham);
    }
}