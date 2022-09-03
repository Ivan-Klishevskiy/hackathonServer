package by.tms.hackathonserver.controller;


import by.tms.hackathonserver.model.Product;
import by.tms.hackathonserver.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        fileService.uploadFile(file);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/image/{fileName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<Resource> image(@PathVariable String fileName) {
        ByteArrayResource byteArrayResource = fileService.loadFile(fileName);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentLength(byteArrayResource.contentLength())
                .body(byteArrayResource);
    }
}
