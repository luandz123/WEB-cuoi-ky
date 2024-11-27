package LPH.StoreManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LPH.StoreManagement.Model.Product;
import LPH.StoreManagement.Service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {
    
        @Autowired
        private ProductService productService;
    
        @GetMapping("/getAll")
        public ResponseEntity<List<Product>> getAllProducts() {
            return ResponseEntity.ok(productService.getAllProduct());
        }
    
        @GetMapping("/{id}")
        public ResponseEntity<Product> getProductById(@PathVariable int id) {
            return ResponseEntity.ok(productService.getProductById(id));
        }
    
        @PostMapping("/create")
        public ResponseEntity<String> createProduct(@RequestBody Product productRequest) {
            return productService.createProduct(productRequest);
        }
    
        @PutMapping("/{id}")
        public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product productRequest) {
            return productService.updateProduct(id, productRequest);
        }
    
        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteProduct(@PathVariable int id) {
            return productService.deleteProduct(id);
        }
}

   


