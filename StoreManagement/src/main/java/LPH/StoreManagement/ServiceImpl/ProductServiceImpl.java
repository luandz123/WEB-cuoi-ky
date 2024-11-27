package LPH.StoreManagement.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import LPH.StoreManagement.Model.Product;
import LPH.StoreManagement.Repository.ProductRepository;
import LPH.StoreManagement.Service.ProductService;
import LPH.StoreManagement.utils.Util;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ResponseEntity<String> createProduct(Product product){
        productRepository.save(product);
        return Util.getResponseEntity("Product created successfully", HttpStatus.OK);
        
    }
    @Override
    public ResponseEntity<String>  updateProduct(int id ,Product producted){
        
        try {
            Product product = productRepository.findProductById(id);
            product.setName(producted.getName());
            product.setPrice(producted.getPrice());
            product.setStock(producted.getStock());
            product.setCategory(producted.getCategory());
            product.setDescription(producted.getDescription());
            product.setImageUrl(producted.getImageUrl());
            product.setCreatedAt(producted.getCreatedAt());
            productRepository.save(producted);
            return Util.getResponseEntity("Product updated successfully", HttpStatus.OK);
        }catch (Exception e) {
            return Util.getResponseEntity("Product not found", HttpStatus.NOT_FOUND);
        }

    }
    public ResponseEntity<String>  deleteProduct(int id){
        try {
            Product product = productRepository.findProductById(id);
            productRepository.delete(product);
            return Util.getResponseEntity("Product deleted successfully", HttpStatus.OK);
        }catch (Exception e) {
            return Util.getResponseEntity("Product not found", HttpStatus.NOT_FOUND);
        }

    }
    public Product  getProductById(int id){
        Product product = productRepository.findProductById(id);
        if (product == null) {
            throw new RuntimeException("Product not found");
        }
        return product;
    }
    public List<Product>  getAllProduct(){
        return productRepository.findAll();

    }
}
