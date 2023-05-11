package com.softwarelearn.lite_mall_backend.service;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

public interface ImageService {
    /**
     * 保存文件
     *
     * @param path 文件路径
     * @param data 文件数据
     * @throws IOException
     */
    void saveFile(String path, byte[] data) throws IOException;
    Optional<File> getFileByPath(String path);
}

