package barang_springboot.barang.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "barang")
//@Builder
public class BarangEntity {

    public interface ViewBarang{
        interface Summary{}
        interface Detail extends Summary{}
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(ViewBarang.Detail.class)
    private Long id;

    @Column(unique = true, nullable = false)
    @JsonView(ViewBarang.Detail.class)
    private String kodeBarang;

    @Column(nullable = false)
    @JsonView(ViewBarang.Detail.class)
    private String namaBarang;

    @Column(nullable = false)
    @JsonView(ViewBarang.Detail.class)
    private Integer jumlahStok;

    @Column(nullable = false)
    @JsonView(ViewBarang.Detail.class)
    private BigDecimal hargaSatuan;

    @Column(nullable = false)
    @JsonView(ViewBarang.Detail.class)
    private LocalDateTime tanggalMasuk;

    @PrePersist
    public void Prepersist(){
        if(tanggalMasuk == null) {
            tanggalMasuk = LocalDateTime.now();
        }
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public Integer getJumlahStok() {
        return jumlahStok;
    }

    public void setJumlahStok(Integer jumlahStok) {
        this.jumlahStok = jumlahStok;
    }

    public BigDecimal getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(BigDecimal hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    public LocalDateTime getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(LocalDateTime tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

}
