package com.example.securefilestorage.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        return "File uploaded successfully";
    }
    @GetMapping("/{id}")
    public String getFile(@PathVariable Long id) {
        return "File retrieved successfully";
    }
}
