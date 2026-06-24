package org.motopart.cloud.controller;

import org.motopart.cloud.dto.response.ImageUploadData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * 26. Image upload. Multipart field name is "profile". The response is the RAW
 * { "url": ... } object (NOT wrapped in the Response envelope) to match the original.
 */
@RestController
public class UploadController {

    @Value("${app.upload.dir}")
    private String uploadDir;

    @Value("${app.upload.public-base-url}")
    private String publicBaseUrl;

    @PostMapping("/upload")
    public ImageUploadData upload(@RequestParam("profile") MultipartFile file) throws IOException {
        Files.createDirectories(Paths.get(uploadDir));
        String original = file.getOriginalFilename() == null ? "file" : file.getOriginalFilename();
        String ext = original.contains(".") ? original.substring(original.lastIndexOf('.')) : "";
        String name = UUID.randomUUID().toString().replace("-", "") + ext;
        Path target = Paths.get(uploadDir, name);
        file.transferTo(target);
        return new ImageUploadData(publicBaseUrl + "/" + name);
    }
}
