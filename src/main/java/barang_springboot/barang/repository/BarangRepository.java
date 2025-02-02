package barang_springboot.barang.repository;

import barang_springboot.barang.entities.BarangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarangRepository extends JpaRepository<BarangEntity, Long> {
}
