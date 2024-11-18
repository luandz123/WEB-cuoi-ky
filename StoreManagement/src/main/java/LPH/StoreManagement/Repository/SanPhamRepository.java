package LPH.StoreManagement.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import LPH.StoreManagement.Model.SanPham;

public interface SanPhamRepository extends JpaRepository<SanPham, Long> {
    List<SanPham> findByTenSanPham(String tenSanPham);
    @Query("SELECT s FROM SanPham s WHERE s.giaBan BETWEEN ?1 AND ?2")
    List<SanPham> findByGiaBanBetween(Double giaMin, Double giaMax);
}
