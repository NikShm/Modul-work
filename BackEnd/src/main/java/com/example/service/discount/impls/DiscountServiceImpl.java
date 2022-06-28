package com.example.service.discount.impls;
/*
 * Interface DiscountServiceImpl
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.example.model.Discount;
import com.example.service.discount.interfaces.IDiscountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements IDiscountService {
    @Override
    public Discount create(Discount discount) {
        return null;
    }

    @Override
    public Discount get(String id) {
        return null;
    }

    @Override
    public Discount update(Discount discount) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Discount> getAll() {
        return null;
    }
}
