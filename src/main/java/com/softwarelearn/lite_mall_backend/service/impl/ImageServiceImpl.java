package com.softwarelearn.lite_mall_backend.service.impl;
import com.softwarelearn.lite_mall_backend.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {
    private static final String FILE_PATH = "/home/lite_mall_backend/images";
    public void saveFile(String path, byte[] data) throws IOException {
        File file = new File(FILE_PATH + path);
        FileUtils.writeByteArrayToFile(file, data);

    }

    public Optional<File> getFileByPath(String path) {
        File file = new File(FILE_PATH + path);
        if (file.exists()) {
            return Optional.of(file);
        } else {
            return Optional.empty();
        }
    }

}
