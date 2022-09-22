package com.example.service.impl;

import com.example.model.BookLoan;
import com.example.repository.IBookLoanRepository;
import com.example.service.IBookLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookLoanService implements IBookLoanService {
    @Autowired
    private IBookLoanRepository iBookLoanRepository;

    @Override
    public void save(BookLoan bookLoan) {
        iBookLoanRepository.save(bookLoan);
    }

    @Override
    public BookLoan findByCode(String code) {
        return iBookLoanRepository.findByCode(code);
    }

    @Override
    public void remove(Integer id) {
        iBookLoanRepository.deleteById(id);
    }
}
