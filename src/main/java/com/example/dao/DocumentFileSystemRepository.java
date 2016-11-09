package com.example.dao;

import com.example.model.Document;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface DocumentFileSystemRepository {

    public void add(Document document) throws IOException;
}
