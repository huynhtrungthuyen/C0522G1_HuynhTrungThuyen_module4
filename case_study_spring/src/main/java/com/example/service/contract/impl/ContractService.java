package com.example.service.contract.impl;

//import com.example.dto.ContractDto;
import com.example.dto.IContractDto;
import com.example.model.contract.Contract;
import com.example.repository.contract.IContractRepositoty;
import com.example.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepositoty iContractRepositoty;

    @Override
    public List<IContractDto> findAllDto() {
        return iContractRepositoty.findAllDto();
    }

    @Override
    public Page<IContractDto> findAllDto(Pageable pageable) {
        return iContractRepositoty.findAllDto(pageable);
    }

    @Override
    public void save(Contract contract) {
        iContractRepositoty.save(contract);
    }

    @Override
    public List<Contract> findAll() {
        return iContractRepositoty.findAll();
    }
}
