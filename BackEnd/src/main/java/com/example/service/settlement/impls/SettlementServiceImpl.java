package com.example.service.settlement.impls;
/*
 * Interface SettlementServiceImpl
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.example.model.Settlement;
import com.example.service.settlement.interfaces.ISettlementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettlementServiceImpl implements ISettlementService {
    @Override
    public Settlement create(Settlement settlement) {
        return null;
    }

    @Override
    public Settlement get(String id) {
        return null;
    }

    @Override
    public Settlement update(Settlement settlement) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Settlement> getAll() {
        return null;
    }
}
