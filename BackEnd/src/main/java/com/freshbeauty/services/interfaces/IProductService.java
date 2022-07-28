package com.freshbeauty.services.interfaces;

import com.freshbeauty.dto.PageDTO;
import com.freshbeauty.dto.ProductDTO;
import com.freshbeauty.dto.SearchDTO;
import com.freshbeauty.entities.Product;

import java.io.IOException;
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
    PageDTO<ProductDTO> getPage(SearchDTO search);
    void update(ProductDTO dto) throws IOException;
}
