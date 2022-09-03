package by.tms.hackathonserver.controller;


import by.tms.hackathonserver.model.Product;
import by.tms.hackathonserver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAllProducts")
    public ResponseEntity<?> getAllProducts() {
        List<Product> allProductByCategory = productService.getAll();
        return new ResponseEntity<>(allProductByCategory, HttpStatus.OK);
    }

    @GetMapping("/getCategoryProduct/{category}")
    public ResponseEntity<?> getAllProductsByCategory(@PathVariable String category) {
        List<Product> allProductByCategory = productService.getAllProductByCategory(category);
        return new ResponseEntity<>(allProductByCategory, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Product product) {
        Product savedProduct = productService.save(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.OK);
    }

    @GetMapping("/getUserProduct/{username}")
    public ResponseEntity<?> getAllProductsByUsername(@PathVariable String username) {
        List<Product> allProductByCreatorName = productService.getAllProductByCreatorName(username);
        return new ResponseEntity<>(allProductByCreatorName, HttpStatus.OK);
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<?> getProductById(@PathVariable long id) {
        Product productById = productService.getProductById(id);
        return new ResponseEntity<>(productById, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<?> deleteProductById(@PathVariable long productId) {
        long deletedProductId = productService.delete(productId);
        return new ResponseEntity<>(deletedProductId, HttpStatus.OK);
    }

}
