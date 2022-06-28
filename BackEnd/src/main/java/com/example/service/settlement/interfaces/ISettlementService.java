package com.example.service.settlement.interfaces;
/*
 * Interface ISettlementService
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.example.model.Settlement;

import java.util.List;

public interface ISettlementService {
    Settlement create(Settlement settlement);
    Settlement get(String id);
    Settlement update(Settlement settlement);
    void delete(String id);
    List<Settlement> getAll();
}
