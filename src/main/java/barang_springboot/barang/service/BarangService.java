package barang_springboot.barang.service;

import barang_springboot.barang.entities.BarangEntity;
import barang_springboot.barang.repository.BarangRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BarangService {

    @Autowired
    private BarangRepository barangRepository;

//    public BarangService(BarangRepository barangRepository) {
//        this.barangRepository = barangRepository;
//    }

//    public List<BarangEntity> getAllBarang(){
//        return barangRepository.findAll();
//    }

//    public BarangEntity save(BarangEntity barangEntity){
//        return barangRepository.save(barangEntity);
//    }
//
//    @Transactional
//    public Optional<BarangEntity> updateBarang(Long id, BarangEntity updatedBarang){
//        return barangRepository.findById(id).map(existingBarang -> {
//            existingBarang.setKodeBarang(updatedBarang.getKodeBarang());
//            existingBarang.setNamaBarang(updatedBarang.getNamaBarang());
//            existingBarang.setJumlahStok(updatedBarang.getJumlahStok());
//            existingBarang.setHargaSatuan(updatedBarang.getHargaSatuan());
//            return barangRepository.save(existingBarang);
//        });
//    }

    //create
    public BarangEntity createBarang(BarangEntity barang) {
        return barangRepository.save(barang);
    }

    //read all
    public List<BarangEntity> getAllBarang() {
        return barangRepository.findAll();
    }

    //update
    public BarangEntity updateBarang(Long id, BarangEntity barangDetails) {
        if (barangRepository.existsById(id)) {
            barangDetails.setId(id);
            return barangRepository.save(barangDetails);
        }
        return null;
    }

    //delete
    public void deleteBarang(Long id) {
        barangRepository.deleteById(id);
    }

}
