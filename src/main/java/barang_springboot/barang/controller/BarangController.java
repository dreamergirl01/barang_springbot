package barang_springboot.barang.controller;

import barang_springboot.barang.entities.BarangEntity;
import barang_springboot.barang.request.BarangRequest;
import barang_springboot.barang.service.BarangService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barang")
@Validated
public class BarangController {

    @Autowired
    private BarangService barangService;

    //create
    @PostMapping("create")
    public ResponseEntity<BarangEntity> createBarang(@RequestBody BarangRequest request) {
        return ResponseEntity.ok(barangService.createBarang(request));
    }

    //read all
    @GetMapping("read")
    public List<BarangEntity> getAllBarang() {
        return barangService.getAllBarang();
    }

    //update
    @PutMapping("edit/{id}")
    public ResponseEntity<BarangEntity> updateBarang(@PathVariable Long id, @RequestBody BarangEntity barangDetails) {
        BarangEntity updatedBarang = barangService.updateBarang(id, barangDetails);
        return updatedBarang != null ? ResponseEntity.ok(updatedBarang) : ResponseEntity.notFound().build();
    }

    //delete
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteBarang(@PathVariable Long id) {
        barangService.deleteBarang(id);
        return ResponseEntity.noContent().build();
    }
}
