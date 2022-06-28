package com.example.repository;
/*
 * Interface IDiscountMongoRepository
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.example.model.Discount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiscountMongoRepository extends MongoRepository<Discount, String> {
}
