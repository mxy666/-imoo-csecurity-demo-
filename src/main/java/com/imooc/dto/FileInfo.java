package com.imooc.dto;

/**
 * create by mxy on 2017/12/25
 */
public class FileInfo {
    String path;
    String fileName;

    public FileInfo(String absolutePath, String name) {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
