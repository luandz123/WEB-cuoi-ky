package LPH.StoreManagement.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import LPH.StoreManagement.Model.Product;

public interface ProductService {
    ResponseEntity<String> createProduct(Product product);
    ResponseEntity<String>  updateProduct(int id,Product producted);
    ResponseEntity<String>  deleteProduct(int id);
    Product  getProductById(int id);
    List<Product>  getAllProduct();
    
}
