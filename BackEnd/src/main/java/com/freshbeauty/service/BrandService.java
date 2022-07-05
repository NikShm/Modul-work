package com.freshbeauty.service;

import com.freshbeauty.IBrandService;
import com.freshbeauty.entities.Brand;
import com.freshbeauty.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
@author Микола
@project AngularTest
@class BrandService
@version 1.0.0
@since 04.07.2022 - 16.18
*/
@Service
public class BrandService implements IBrandService {
    @Autowired
    private BrandRepository repository;

    @Override
    public List<Brand> findAll() {

        return repository.findAll();
    }
}
