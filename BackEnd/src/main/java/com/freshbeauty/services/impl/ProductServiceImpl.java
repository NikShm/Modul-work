package com.freshbeauty.services.impl;

import com.freshbeauty.dto.PageDTO;
import com.freshbeauty.dto.ProductDTO;
import com.freshbeauty.dto.SearchDTO;
import com.freshbeauty.dto.SortDirection;
import com.freshbeauty.entities.Product;
import com.freshbeauty.enums.CategoryType;
import com.freshbeauty.mappers.ProductMapper;
import com.freshbeauty.repositories.ProductRepository;
import com.freshbeauty.services.IProductService;
import com.freshbeauty.utils.QueryHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        return repository.findById(id).map(mapper::toDto).orElse(null);
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

    @Override
    public PageDTO<ProductDTO> getPage(SearchDTO search) {
        Sort sort = Sort.by(search.getSortField());
        if (search.getSortDirection() == SortDirection.DESC) {
            sort = sort.descending();
        }
        Pageable pageable = PageRequest.of(search.getPage(), search.getPageSize(), sort);
        Page<Product> all = repository.findAll((root, query, criteriaBuilder) -> getPredicate(search, criteriaBuilder, root), pageable);
        PageDTO<ProductDTO> dto = new PageDTO<>();
        dto.setContent(all.stream().map(mapper::toDto).collect(Collectors.toList()));
        dto.setPageCount(all.getTotalPages());
        dto.setPage(all.getNumber());
        dto.setPageSize(all.getSize());
        return dto;
    }

    private Predicate getPredicate(SearchDTO search, CriteriaBuilder criteriaBuilder, Root<Product> product) {
        List<Predicate> predicates = new ArrayList<>();
        String value = search.getName();
        if (value != null) {
            predicates.add(QueryHelper.ilike(product.get("name"), criteriaBuilder, value));
        }
        value = search.getBrand();
        if (value != null) {
            predicates.add(QueryHelper.ilike(product.join("brand").get("name"), criteriaBuilder, value));
        }
        if (search.getCategoryType() != null) {
            predicates.add(criteriaBuilder.equal(product.get("category"), search.getCategoryType()));
        }
        return predicates.size() == 1 ? predicates.get(0) : criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
