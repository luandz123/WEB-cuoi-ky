package LPH.StoreManagement.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import LPH.StoreManagement.Model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findProductById(int id);
}

