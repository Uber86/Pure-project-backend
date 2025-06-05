package com.example.pure.controller;

import com.example.pure.service.ImageService;
import liquibase.resource.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
public class ImageController {
    private final ImageService service;

    public ImageController(ImageService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        String name = service.saveImage(file);
        return ResponseEntity.ok("/image" + name);
    }

    @GetMapping("/{filename}")
    public ResponseEntity<UrlResource> getImage(@PathVariable String filename) {
        UrlResource resource = service.loadImage(filename);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
    }

}
