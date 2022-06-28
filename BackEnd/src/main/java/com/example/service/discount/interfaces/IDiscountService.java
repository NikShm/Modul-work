package com.example.service.discount.interfaces;
/*
 * Interface IDiscountService
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.example.model.Discount;

import java.util.List;

public interface IDiscountService {
    Discount create(Discount discount);
    Discount get(String id);
    Discount update(Discount discount);
    void delete(String id);
    List<Discount> getAll();
}
