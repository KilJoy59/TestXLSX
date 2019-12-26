package main.controller;

import main.payload.UploadFileResponse;
import main.property.FileStorageProperties;
import main.service.FileService;
import main.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;

@RestController
public class UploadController {

    @Autowired
    FileService fileService;

    @Autowired
    FileStorageService fileStorageService;

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        String fileName = fileStorageService.storeFile(multipartFile);
        try {
            fileService.unZip(multipartFile);
            for (File file : fileService.getUnzipFiles()) {
                fileService.parseXLSX(file);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
                multipartFile.getContentType(), multipartFile.getSize());
    }
}
