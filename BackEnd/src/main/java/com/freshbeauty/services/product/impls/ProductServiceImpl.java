package com.freshbeauty.services.product.impls;

import com.freshbeauty.dto.ProductDTO;
import com.freshbeauty.entities.Product;
import com.freshbeauty.mappers.ProductMapper;
import com.freshbeauty.repositories.ProductRepository;
import com.freshbeauty.services.product.interfaces.IProductService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project FreshBeauty
 * @class ProductServiceImpl
 * @since 7/6/2022 - 20.29
 **/
@Service
public class ProductServiceImpl implements IProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductServiceImpl(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductDTO> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getOne(Integer id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<ProductDTO> getLastProducts(int quantity) {
        Pageable page = PageRequest.of(0, quantity, Sort.by("createdAt").descending());
        return repository.findAll(page).stream().map(mapper::toDto).collect(Collectors.toList());
    }
}
