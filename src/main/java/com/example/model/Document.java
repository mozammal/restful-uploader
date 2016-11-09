package com.example.model;

public class Document {


    private byte[] content;

    private String name;

    public Document(String name, byte[] content) {
        this.setContent(content);
        this.setName(name);
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public String getName() {
        return name;
    }
}
