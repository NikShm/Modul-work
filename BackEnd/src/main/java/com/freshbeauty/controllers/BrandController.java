package com.freshbeauty.controllers;

import com.freshbeauty.dto.BrandDTO;
import java.util.List;

import com.freshbeauty.services.impls.BrandServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://api.besida.cf", "https://demo.besida.cf"})
@RequestMapping(value = "/api/brands", produces = "application/json")
public class BrandController {
    private final BrandServiceImpl service;

    public BrandController(BrandServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public BrandDTO showOne(@PathVariable Integer id) {
        return service.getOne(id);
    }

    @GetMapping("/")
    public List<BrandDTO> showAll() {
        return service.getAll();
    }
}
