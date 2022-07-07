package com.freshbeauty.mappers;

import com.freshbeauty.dto.ProductDTO;
import com.freshbeauty.entities.Product;
import org.springframework.stereotype.Component;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project FreshBeauty
 * @class ProductMapper
 * @since 7/7/2022 - 08.34
 **/
@Component
public class ProductMapper {
   public ProductDTO toDto(Product entity) {
       ProductDTO dto = new ProductDTO();

       dto.setId(entity.getId());
       dto.setName(entity.getName());
       dto.setDescription(entity.getDescription());
       dto.setBrandName(entity.getBrand().getName());
       dto.setBrandId(entity.getBrand().getId());
       dto.setPrice(entity.getPrice());
       dto.setCategory(entity.getCategory());
       dto.setColor(entity.getColor());
       dto.setVolume(entity.getVolume());
       dto.setPhotoPath(entity.getPhotoPath());

       return dto;
   }

    /* to do
    public Product toEntity(ProductDTO dto) {

    }*/
}
