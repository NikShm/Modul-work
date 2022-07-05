package com.freshbeauty.controllers;

import com.freshbeauty.entities.Brand;
import com.freshbeauty.repositories.BrandRepository;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController("brand")
@CrossOrigin(origins = "http://localhost:4200")
public class BrandController {
    private final BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping("/byId/{id}")
    public BrandDTO get(@PathVariable Integer id) {
        return brandRepository.findById(id).map(BrandDTO::new).get();
    }

    @GetMapping("/list")
    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }

    @PostMapping
    void addUser(@RequestBody Brand user) {
        brandRepository.save(user);
    }
}
