package com.project.main.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface S3BucketService {
    // Upload file
    String uploadFile(MultipartFile file) throws IOException;

    // Download file
    byte[] downloadFile(String key) throws IOException;

    // Delete file
    void deleteFile(String key);
}
