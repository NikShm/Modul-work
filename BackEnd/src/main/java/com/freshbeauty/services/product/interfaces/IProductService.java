package com.freshbeauty.services.product.interfaces;

import com.freshbeauty.dto.ProductDTO;
import com.freshbeauty.entities.Product;

import java.util.List;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project FreshBeauty
 * @class IProductService
 * @since 7/6/2022 - 20.26
 **/
public interface IProductService {
    List<ProductDTO> getAll();
    ProductDTO getOne(Integer id);
    void delete(Integer id);
    List<ProductDTO> getLastProducts(int quantity);
}
