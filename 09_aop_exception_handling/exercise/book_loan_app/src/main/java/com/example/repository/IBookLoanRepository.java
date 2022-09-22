package com.example.repository;

import com.example.model.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookLoanRepository extends JpaRepository<BookLoan, Integer> {
    BookLoan findByCode(String code);
}
