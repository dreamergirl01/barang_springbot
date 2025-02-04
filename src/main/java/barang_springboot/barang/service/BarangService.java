package barang_springboot.barang.service;

import barang_springboot.barang.entity.BarangEntity;
import barang_springboot.barang.repository.BarangRepository;
import barang_springboot.barang.request.BarangRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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

    public List<BarangEntity> getBarangFiltered(String namaBarang, Integer jumlahStok, String sortBy, String sortDirection){
        return barangRepository.findAllWithFilters(namaBarang, jumlahStok, sortBy, sortDirection);
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
