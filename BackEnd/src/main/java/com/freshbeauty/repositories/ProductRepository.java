package com.freshbeauty.repositories;

import com.freshbeauty.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project FreshBeauty
 * @class ProductRepository
 * @since 7/6/2022 - 20.22
 **/
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
