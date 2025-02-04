package barang_springboot.barang.repository;

import barang_springboot.barang.entity.BarangEntity;

import java.util.List;

public interface BarangCustomRepository {
    List<BarangEntity> findAllWithFilters(String namaBarang, Integer jumlahStok, String sortBy, String sortDirection);
}
