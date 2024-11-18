package LPH.StoreManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import LPH.StoreManagement.Model.NhanVien;
import LPH.StoreManagement.Service.NhanVienService;

@RestController
@CrossOrigin(origins = "http://localhost:3000") 
@RequestMapping("/NhanVien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("/getAll")
    public List<NhanVien> getAllNhanVien() {
        return nhanVienService.getAllNhanVien();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NhanVien> getNhanVienById(@PathVariable Long id) {
        NhanVien nhanVien = nhanVienService.getNhanVienById(id);
        return ResponseEntity.ok(nhanVien);
    }

    @PostMapping("/add")
    public ResponseEntity<NhanVien> createNhanVien(@RequestBody NhanVien nhanVien) {
        NhanVien newNhanVien = nhanVienService.createNhanVien(nhanVien);
        return ResponseEntity.status(HttpStatus.CREATED).body(newNhanVien);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NhanVien> updateNhanVien(@PathVariable Long id, @RequestBody NhanVien nhanVien) {
        NhanVien updatedNhanVien = nhanVienService.updateNhanVien(id, nhanVien);
        return ResponseEntity.ok(updatedNhanVien);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNhanVien(@PathVariable Long id) {
        nhanVienService.deleteNhanVien(id);
        return ResponseEntity.noContent().build();
    }
}
