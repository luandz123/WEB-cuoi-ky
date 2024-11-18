package LPH.StoreManagement.SeviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import LPH.StoreManagement.Model.TonKho;
import LPH.StoreManagement.Repository.TonKhoRepository;
import LPH.StoreManagement.Service.TonKhoService;

@Service
public class TonKhoServiceImpl implements TonKhoService {

    @Autowired
    private TonKhoRepository tonKhoRepository;

    @Override
    public TonKho createTonKho(TonKho tonKho) {
        return tonKhoRepository.save(tonKho);
    }

    @Override
    public List<TonKho> getAllTonKho() {
        return tonKhoRepository.findAll();
    }

    @Override
    public TonKho getTonKhoById(Long id) {
        return tonKhoRepository.findById(id).orElseThrow(() -> new RuntimeException("TonKho not found with id: " + id));
    }

    @Override
    public TonKho updateTonKho(Long id, TonKho tonKhoDetails) {
        TonKho tonKho = tonKhoRepository.findById(id).orElseThrow(() -> new RuntimeException("TonKho not found with id: " + id));
        tonKho.setMaHang(tonKhoDetails.getMaHang());
        tonKho.setTenSanPham(tonKhoDetails.getTenSanPham());
        tonKho.setSoLuong(tonKhoDetails.getSoLuong());
        tonKho.setVonTonKho(tonKhoDetails.getVonTonKho());
        tonKho.setGiaTriTon(tonKhoDetails.getGiaTriTon());
        return tonKhoRepository.save(tonKho);
    }

    @Override
    public void deleteTonKho(Long id) {
        TonKho tonKho = tonKhoRepository.findById(id).orElseThrow(() -> new RuntimeException("TonKho not found with id: " + id));
        tonKhoRepository.delete(tonKho);
    }
}
