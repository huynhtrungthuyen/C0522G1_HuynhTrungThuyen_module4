package com.example.controller;

import com.example.dto.IContractDetailDto;
import com.example.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/contract/v1")
@CrossOrigin("*")
public class ContractDetailController {
    @Autowired
    private IContractDetailService iContractDetailService;

    @GetMapping("/{id}")
    public ResponseEntity<List<IContractDetailDto>> showAll(@PathVariable int id) {
        List<IContractDetailDto> list = iContractDetailService.showAll(id);

        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
