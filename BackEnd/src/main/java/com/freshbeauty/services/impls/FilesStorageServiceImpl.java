package com.freshbeauty.services.impls;

import com.freshbeauty.services.interfaces.IFilesStorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project FreshBeauty
 * @class FilesStorageServiceImpl
 * @since 7/27/2022 - 21.33
 **/
@Service
public class FilesStorageServiceImpl implements IFilesStorageService {
    private final Path root = Paths.get("FrontEnd/src");
    @Override
    public void save(MultipartFile file, String path) throws IOException {
        Files.copy(file.getInputStream(), this.root.resolve(path));
    }

    @Override
    public void delete(String filePath) throws IOException {
        Files.deleteIfExists(this.root.resolve(filePath));
    }

    @Override
    public void move(String oldPath, String newPath) throws IOException {
        Files.move(this.root.resolve(oldPath), this.root.resolve(newPath), StandardCopyOption.REPLACE_EXISTING);
    }

    @Override
    public boolean exists(String path) {
        return Files.exists(this.root.resolve(path));
    }
}
