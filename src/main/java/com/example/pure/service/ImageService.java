package com.example.pure.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Class service для получения и обработка картинок
 */
@Service
public class ImageService {
    private final Path uploadDir;

    public ImageService(@Value("${app.upload.dir:upload-dir}") String uploadDir) {
        this.uploadDir = Paths.get(uploadDir);
    }

    public String saveImage(MultipartFile file) {
        try {
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }
            String name = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path path = uploadDir.resolve(name);
            file.transferTo(path);
            return name;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public UrlResource loadImage(String filename) {
        try{
            Path file = uploadDir.resolve(filename);
            UrlResource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException();

            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
