package com.freshbeauty.controllers;

import com.freshbeauty.dto.PageDTO;
import com.freshbeauty.dto.ProductDTO;
import com.freshbeauty.dto.SearchDTO;
import com.freshbeauty.services.impls.FilesStorageServiceImpl;
import com.freshbeauty.services.impls.ProductServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project FreshBeauty
 * @class ProductController
 * @since 7/6/2022 - 20.21
 **/
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/products", produces = "application/json")
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private final ProductServiceImpl service;
    private final FilesStorageServiceImpl fileService;

    public ProductController(ProductServiceImpl service, FilesStorageServiceImpl fileService)
    {
        this.service = service;
        this.fileService = fileService;
    }

    @PostMapping("/search")
    public PageDTO<ProductDTO> search(@RequestBody SearchDTO search) {
        LOGGER.info("search(search={})", search);
        return service.getPage(search);
    }

    @GetMapping
    public List<ProductDTO> showAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ProductDTO showOne(@PathVariable Integer id) {
        return service.getOne(id);
    }

    @GetMapping("/last-{n}")
    public List<ProductDTO> showLast(@PathVariable Integer n) {
        return service.getLastProducts(n);
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable Integer id) throws IOException {
        service.delete(id);
    }

    @PutMapping( "/update/")
    public void update(@RequestBody ProductDTO productDTO) throws IOException {
        this.service.update(productDTO);
    }

    @PostMapping("/uploadPhoto/")
    public void upload(@RequestPart MultipartFile photo, @RequestParam String newPath,
                       @RequestParam(required = false) String oldPath,
                       @RequestParam(required = false) Integer id) throws IOException {
        if (oldPath != null) {
            this.fileService.delete(oldPath);
        }
        this.fileService.save(photo, newPath);
        if (id != null) {
            this.service.updatePhotoPath(id, newPath);
        }
    }

    @PostMapping("/create/")
    public Integer create(@RequestBody ProductDTO productDTO) {
        return this.service.create(productDTO);
    }
}
