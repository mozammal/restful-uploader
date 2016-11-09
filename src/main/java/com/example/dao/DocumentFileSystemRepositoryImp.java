package com.example.dao;

import com.example.facade.RestServieResourceFacade;
import com.example.model.Document;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;

@Component
public class DocumentFileSystemRepositoryImp implements DocumentFileSystemRepository {

    private static final Logger LOG = Logger.getLogger(DocumentFileSystemRepositoryImp.class);

    @Value("${file.repository}")
    private String fileStorageLocation;

    @PostConstruct
    public void init() {
        createDirectory(fileStorageLocation);
    }

    @Override
    public void add(Document document) throws IOException {

        if (org.springframework.util.StringUtils.isEmpty(document.getName())) {
            LOG.info("file name cant be null");
            throw new IOException();
        }

        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(fileStorageLocation, document.getName())));
        stream.write(document.getContent());
        stream.close();
    }

    private void createDirectory(String path) {
        File file = new File(path);
        file.mkdirs();

    }
}
