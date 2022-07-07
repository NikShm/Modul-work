package com.freshbeauty.mappers;

import com.freshbeauty.dto.BrandDTO;
import com.freshbeauty.entities.Brand;
import org.springframework.stereotype.Component;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project FreshBeauty
 * @class BrandMapper
 * @since 7/6/2022 - 15.35
 **/
@Component
public class BrandMapper {
    public BrandDTO toDto(Brand entity) {
        BrandDTO dto = new BrandDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }

    public Brand toEntity(BrandDTO dto) {
        Brand entity = new Brand();
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        return entity;
    }
}
