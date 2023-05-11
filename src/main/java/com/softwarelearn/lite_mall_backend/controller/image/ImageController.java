package com.softwarelearn.lite_mall_backend.controller.image;
import com.softwarelearn.lite_mall_backend.constant.R;
import com.softwarelearn.lite_mall_backend.constant.ResultCode;
import com.softwarelearn.lite_mall_backend.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.net.www.URLConnection;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    /**
     * 文件上传
     *
     * @param file
     * @param path
     * @return
     */
    @PostMapping("/upload")
    public R uploadFile(@RequestParam("file") MultipartFile file,
                        @RequestParam("path") String path) {
        try {
            byte[] bytes = file.getBytes();
            imageService.saveFile(path, bytes);
        } catch (IOException e) {
            return R.error(ResultCode.FAIL, null);
        }
        return R.success(ResultCode.SUCCESS, null);
    }
    @GetMapping("/download")
    public R getFile(@RequestParam("path") String path) {
        Optional<File> optionalFile = imageService.getFileByPath(path);
        if (optionalFile.isPresent()) {
            File file = optionalFile.get();
            String contentType = URLConnection.guessContentTypeFromName(file.getName());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(contentType));
            headers.setContentDisposition(ContentDisposition.builder("attachment")
                    .filename(file.getName(), StandardCharsets.UTF_8)
                    .build());
            try {
                byte[] data = FileUtils.readFileToByteArray(file);
                return R.success(ResultCode.SUCCESS, data);
            } catch (IOException e) {
                return R.error(ResultCode.FAIL, null);
            }
        } else {
            return R.error(ResultCode.FILE_NOT_FOUND, null);
        }
    }
}


