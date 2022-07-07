package com.freshbeauty.services.brand.interfaces;
/*
@author Микола
@project FreshBeauty
@class IBrandService
@version 1.0.0
@since 04.07.2022 - 16.17
*/

import com.freshbeauty.dto.BrandDTO;
import com.freshbeauty.entities.Brand;

import java.util.List;

public interface IBrandService {
    List<BrandDTO> getAll();
    BrandDTO getOne(Integer id);
}
