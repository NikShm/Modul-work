package com.freshbeauty.mappers;

import com.freshbeauty.dto.ProductDTO;
import com.freshbeauty.entities.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project FreshBeauty
 * @class ProductMapper
 * @since 7/7/2022 - 08.34
 **/
@Component
public class ProductMapper {
    private final BrandMapper brandMapper;

    public ProductMapper(BrandMapper brandMapper) {
        this.brandMapper = brandMapper;
    }

   public ProductDTO toDto(Product entity) {
       ProductDTO dto = new ProductDTO();

       dto.setId(entity.getId());
       dto.setName(entity.getName());
       dto.setDescription(entity.getDescription());
       dto.setBrand(brandMapper.toDto(entity.getBrand()));
       dto.setPrice(entity.getPrice());
       dto.setCategory(entity.getCategory());
       dto.setColor(entity.getColor());
       dto.setVolume(entity.getVolume());
       dto.setPhotoPath(entity.getPhotoPath());

       return dto;
   }

    public Product toEntity(Product entity, ProductDTO dto) {
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setCategory(dto.getCategory());
        entity.setColor(dto.getColor());
        entity.setVolume(dto.getVolume());
        entity.setPhotoPath(dto.getPhotoPath());

        return entity;
    }
}
