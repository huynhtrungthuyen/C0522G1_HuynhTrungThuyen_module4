package com.example.service.contract;

import com.example.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);
}
