package com.example.service.contract;

import com.example.dto.IContractDto;
import com.example.model.contract.Contract;

import java.util.List;

public interface IContractService {
    List<IContractDto> findAllDto();

//    Page<IContractDto> findAllDto(Pageable pageable);

    void save(Contract contract);

    List<Contract> findAll();
}
