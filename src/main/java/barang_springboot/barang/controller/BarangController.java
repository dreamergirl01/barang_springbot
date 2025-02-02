package barang_springboot.barang.controller;

import barang_springboot.barang.entities.BarangEntity;
import barang_springboot.barang.service.BarangService;
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

//    public BarangController(BarangService barangService) {
//        this.barangService = barangService;
//    }


//    @PostMapping
//    public BarangEntity createBarang(@RequestBody BarangRequest barangRequest){
//        BarangEntity barangEntity = new BarangEntity();
//        barangEntity.setKodeBarang(barangRequest.getKodeBarang());
//        barangEntity.setNamaBarang(barangRequest.getNamaBarang());
//        barangEntity.setJumlahStok(barangRequest.getJumlahStok());
//        barangEntity.setHargaSatuan(barangRequest.getHargaSatuan());
//        barangEntity.setTanggalMasuk(LocalDateTime.now());
//        return barangService.save(barangEntity);
//    }

    //create
    @PostMapping("create")
    public ResponseEntity<BarangEntity> createBarang(@RequestBody BarangEntity barang) {
        BarangEntity newBarang = barangService.createBarang(barang);
        return ResponseEntity.ok(newBarang);
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
