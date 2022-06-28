package com.example.repository;
/*
 * Interface ISettlementMongoRepository
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.example.model.Settlement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISettlementMongoRepository extends MongoRepository<Settlement, String> {
}
