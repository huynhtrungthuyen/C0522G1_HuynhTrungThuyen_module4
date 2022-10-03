package com.example.repository.contract;

import com.example.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
}
