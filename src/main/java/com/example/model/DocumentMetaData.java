package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;

@Entity
public class DocumentMetaData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Date lastModified;

    private String fileLocation;

    public DocumentMetaData() {
    }

    public DocumentMetaData(String name, String fileLocation, Date lastModified) {
        this.setLastModified(lastModified);
        this.setName(name);
        this.setFileLocation(fileLocation);

    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public String getName() {
        return name;
    }

    public String getFileLocation() {
        return fileLocation;
    }
}
