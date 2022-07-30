package com.freshbeauty.services.impls;

import com.freshbeauty.dto.BrandDTO;
import com.freshbeauty.mappers.BrandMapper;
import com.freshbeauty.services.IBrandService;
import com.freshbeauty.repositories.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
@author Микола
@project FreshBeauty
@class BrandService
@version 1.0.0
@since 04.07.2022 - 16.18
*/
@Service
public class BrandServiceImpl implements IBrandService {
    private final BrandRepository repository;
    private final BrandMapper mapper;

    public BrandServiceImpl(BrandRepository repository, BrandMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<BrandDTO> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public BrandDTO getOne(Integer id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }
}
