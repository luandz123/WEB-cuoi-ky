package LPH.StoreManagement.Model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "khach_hang")
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ma_khach_hang", unique = true, nullable = false)
    private String maKhachHang;

    @Column(name = "ten_khach_hang", nullable = false)
    private String tenKhachHang;

    @Column(name = "dien_thoai")
    private String dienThoai;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "lan_cuoi_mua_hang")
    private LocalDateTime lanCuoiMuaHang;

    @Column(name = "tong_tien_hang")
    private BigDecimal tongTienHang;

    @Column(name = "tong_no")
    private BigDecimal tongNo;

    public KhachHang() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public LocalDateTime getLanCuoiMuaHang() {
		return lanCuoiMuaHang;
	}

	public void setLanCuoiMuaHang(LocalDateTime lanCuoiMuaHang) {
		this.lanCuoiMuaHang = lanCuoiMuaHang;
	}

	public BigDecimal getTongTienHang() {
		return tongTienHang;
	}

	public void setTongTienHang(BigDecimal tongTienHang) {
		this.tongTienHang = tongTienHang;
	}

	public BigDecimal getTongNo() {
		return tongNo;
	}

	public void setTongNo(BigDecimal tongNo) {
		this.tongNo = tongNo;
	}
    
}

