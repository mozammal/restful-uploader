package com.example.service;

import com.example.dao.DocumentFileSystemRepository;
import com.example.model.Document;
import com.example.model.DocumentMetaData;
import com.example.repository.DocumentMetaDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Service
public class FileUploadService {


    @Value("${file.repository}")
    private String fileStorageLocation;

    @Autowired
    DocumentFileSystemRepository documentFileSystemRepository;

    @Autowired
    DocumentMetaDataRepository documentRepository;

    public void upload(MultipartFile file) throws IOException {

        String fileName = file.getOriginalFilename();
        byte[] content = file.getBytes();
        Date currentDate = new Date();
        Document document = new Document(fileName, content);
        DocumentMetaData documentMetaData = new DocumentMetaData(fileName, fileStorageLocation, currentDate);
        documentFileSystemRepository.add(document);
        documentRepository.save(documentMetaData);
    }
}
