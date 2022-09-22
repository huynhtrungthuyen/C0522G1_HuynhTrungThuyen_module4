package com.example.service;

import com.example.model.BookLoan;

public interface IBookLoanService {
    void save(BookLoan bookLoan);

    BookLoan findByCode(String code);

    void remove(Integer id);
}
