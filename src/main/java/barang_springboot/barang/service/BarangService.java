package barang_springboot.barang.service;

import barang_springboot.barang.entities.BarangEntity;
import barang_springboot.barang.repository.BarangRepository;
import barang_springboot.barang.request.BarangRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BarangService {

    @Autowired
    private BarangRepository barangRepository;

    //create
    public BarangEntity createBarang(BarangRequest request) {
        BarangEntity barang = new BarangEntity();
        barang.setKodeBarang(generateKodeBarang());
        barang.setNamaBarang(request.getNamaBarang());
        barang.setJumlahStok(request.getJumlahStok());
        barang.setHargaSatuan(request.getHargaSatuan());
        barang.setTanggalMasuk(LocalDateTime.now());

        return barangRepository.save(barang);
    }

    private String generateKodeBarang() {
        return "BRG-" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();
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
