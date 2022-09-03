package by.tms.hackathonserver.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    //
//    private String fileDir;
    @Value("${dir.uploadFiles}")
    private String path;

    public void uploadFile(MultipartFile file) {

        try {
            file.transferTo(new File(path + file.getOriginalFilename()));
        } catch (IOException e) {
            throw new RuntimeException("Error uploadFile");
        }
    }

    public ByteArrayResource loadFile(String fileName) {
        final ByteArrayResource inputStream;
        System.out.println(path + File.separator + fileName + ".jpg");
        try {
            inputStream = new ByteArrayResource(Files.readAllBytes(Paths.get(
                    path + File.separator + fileName + ".jpg"
            )));
        } catch (IOException e) {
            throw new RuntimeException("Fail");
        }
        return inputStream;
    }
}
