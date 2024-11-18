package LPH.StoreManagement.Model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class TonKho{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String maHang;

    @Column(nullable = false)
    private String tenSanPham;

    private int soLuong;

    private Long vonTonKho;

    private Long giaTriTon;

    public TonKho() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Long getVonTonKho() {
        return vonTonKho;
    }

    public void setVonTonKho(Long vonTonKho) {
        this.vonTonKho = vonTonKho;
    }

    public Long getGiaTriTon() {
        return giaTriTon;
    }

    public void setGiaTriTon(Long giaTriTon) {
        this.giaTriTon = giaTriTon;
    }
}

