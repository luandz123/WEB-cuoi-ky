package LPH.StoreManagement.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import LPH.StoreManagement.Model.TonKho;
import LPH.StoreManagement.Service.TonKhoService;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin
@RequestMapping("/TonKho")
public class TonKhoController {

    @Autowired
    private TonKhoService tonKhoService;

    @GetMapping("/getAll")
    public List<TonKho> getAllTonKho() {
        return tonKhoService.getAllTonKho();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TonKho> getTonKhoById(@PathVariable Long id) {
        return ResponseEntity.ok(tonKhoService.getTonKhoById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<TonKho> createTonKho(@RequestBody TonKho tonKho) {
        return ResponseEntity.ok(tonKhoService.createTonKho(tonKho));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TonKho> updateTonKho(@PathVariable Long id, @RequestBody TonKho tonKho) {
        return ResponseEntity.ok(tonKhoService.updateTonKho(id, tonKho));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTonKho(@PathVariable Long id) {
        tonKhoService.deleteTonKho(id);
        return ResponseEntity.noContent().build();
    }
}
