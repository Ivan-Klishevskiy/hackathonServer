//package by.tms.hackathonserver.controller;
//
//
//import by.tms.hackathonserver.model.Product;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//@RequestMapping("/file")
//public class FileController {
//
//    @PostMapping("/save")
//    public ResponseEntity<?> save(@RequestParam("file") MultipartFile file) {
//        Product savedProduct = productService.save(product);
//        return new ResponseEntity<>(savedProduct, HttpStatus.OK);
//    }
//}
