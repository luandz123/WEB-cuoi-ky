package LPH.StoreManagement.Model;

import jakarta.persistence.*;

@Entity
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stt;

    private String maNhanVien;
    private String tenNhanVien;
    private String email;

    @Enumerated(EnumType.STRING)
    private UserGroup nhomNguoiSuDung;

    @Enumerated(EnumType.STRING)
    private Status trangThai;

    public enum UserGroup {
        ADMIN, QUAN_LY, NHAN_VIEN
    }

    public enum Status {
        HOAT_DONG, TAM_NGUNG
    }

    // Getters and Setters
    public Long getStt() {
        return stt;
    }

    public void setStt(Long stt) {
        this.stt = stt;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserGroup getNhomNguoiSuDung() {
        return nhomNguoiSuDung;
    }

    public void setNhomNguoiSuDung(UserGroup nhomNguoiSuDung) {
        this.nhomNguoiSuDung = nhomNguoiSuDung;
    }

    public Status getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Status trangThai) {
        this.trangThai = trangThai;
    }
}
