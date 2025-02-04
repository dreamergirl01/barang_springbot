package barang_springboot.barang.request;

import java.math.BigDecimal;

public class BarangRequest {
    private String namaBarang;
    private Integer jumlahStok;
    private BigDecimal hargaSatuan;

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
}
