package LPH.StoreManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import LPH.StoreManagement.Model.KhachHang;

import java.util.Optional;

public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {
    Optional<KhachHang> findByMaKhachHang(String maKhachHang);
}

