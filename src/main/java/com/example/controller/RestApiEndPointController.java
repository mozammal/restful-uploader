package com.example.controller;

import com.example.facade.RestServieResourceFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/rest")
public class RestApiEndPointController {

    private static final Logger LOG = Logger.getLogger(RestApiEndPointController.class);

    @Autowired
    RestServieResourceFacade restServieResourceFacade;

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public ResponseEntity<?> upload(@RequestPart(value = "file", required = true) MultipartFile file) throws IOException {

        if (!file.isEmpty()) {

            restServieResourceFacade.upload(file);
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
