package barang_springboot.barang.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "barang")
//@Builder
public class BarangEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String kodeBarang;

    @Column(nullable = false)
    private String namaBarang;

    @Column(nullable = false)
    private Integer jumlahStok;

    @Column(nullable = false)
//    @JsonSerialize(using = RupiahSerializer.class)
    private BigDecimal hargaSatuan;

    @Column(nullable = false)
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

    @JsonIgnore
    public Long getIdOnCreate() {
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
