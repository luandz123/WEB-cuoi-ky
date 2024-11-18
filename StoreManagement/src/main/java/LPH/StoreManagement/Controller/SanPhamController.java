package LPH.StoreManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import LPH.StoreManagement.Model.SanPham;
import LPH.StoreManagement.Service.SanPhamService;


import java.util.List;

@RestController
@RequestMapping("/sanPham")
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("/getAll")
    public List<SanPham> layTatCaSanPham() {
        return sanPhamService.layTatCaSanPham();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SanPham> laySanPhamTheoId(@PathVariable Long id) {
        return sanPhamService.laySanPhamTheoId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SanPham taoSanPham(@RequestBody SanPham sanPham) {
        return sanPhamService.taoSanPham(sanPham);
    }


    @PutMapping("/{id}")
    public ResponseEntity<SanPham> capNhatSanPham(@PathVariable Long id, @RequestBody SanPham chiTietSanPham) {
        return ResponseEntity.ok(sanPhamService.capNhatSanPham(id, chiTietSanPham));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> xoaSanPham(@PathVariable Long id) {
        sanPhamService.xoaSanPham(id);
        return ResponseEntity.noContent().build();
        }
        
    @GetMapping("/ten")
    public List<SanPham> laySanPhamTheoTen(@RequestParam String tenSanPham) {
        return sanPhamService.laySanPhamTheoTen(tenSanPham);

}
}
