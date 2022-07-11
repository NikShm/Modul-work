package com.freshbeauty.controllers;

import com.freshbeauty.dto.ProductDTO;
import com.freshbeauty.services.product.impls.ProductServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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
    private final ProductServiceImpl service;

    public ProductController(ProductServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/page/{page}")
    public List<ProductDTO> findPaginated(@PathVariable Integer page) {
        return service.getLastProducts(page);
    }

    @GetMapping("/")
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
    public void deleteOne(@PathVariable Integer id) {
        service.delete(id);
    }
}
