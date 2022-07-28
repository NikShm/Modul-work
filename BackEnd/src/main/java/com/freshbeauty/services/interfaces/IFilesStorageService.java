package com.freshbeauty.services.interfaces;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project FreshBeauty
 * @class FilesStorageService
 * @since 7/27/2022 - 21.32
 **/
public interface IFilesStorageService {
    void save(MultipartFile file, String path) throws IOException;
    void delete(String filePath) throws IOException;
    void move(String oldPath, String newPath) throws IOException;
    boolean exists(String path);
}
