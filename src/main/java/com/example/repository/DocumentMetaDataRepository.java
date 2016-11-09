package com.example.repository;

import com.example.model.Document;
import com.example.model.DocumentMetaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentMetaDataRepository extends JpaRepository<DocumentMetaData, Long>{

}
