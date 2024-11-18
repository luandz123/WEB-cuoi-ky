package LPH.StoreManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import LPH.StoreManagement.Model.KhachHang;
import LPH.StoreManagement.Service.KhachHangService;

import java.util.List;

@RestController
@RequestMapping("/api/khach-hang")
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;

    @GetMapping
    public List<KhachHang> layTatCaKhachHang() {
        return khachHangService.layTatCaKhachHang();
    }

    @GetMapping("/{id}")
    public ResponseEntity<KhachHang> layKhachHangTheoId(@PathVariable Long id) {
        return khachHangService.layKhachHangTheoId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public KhachHang taoKhachHang(@RequestBody KhachHang khachHang) {
        return khachHangService.taoKhachHang(khachHang);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KhachHang> capNhatKhachHang(@PathVariable Long id, @RequestBody KhachHang chiTietKhachHang) {
        return ResponseEntity.ok(khachHangService.capNhatKhachHang(id, chiTietKhachHang));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> xoaKhachHang(@PathVariable Long id) {
        khachHangService.xoaKhachHang(id);
        return ResponseEntity.noContent().build();
    }
}

