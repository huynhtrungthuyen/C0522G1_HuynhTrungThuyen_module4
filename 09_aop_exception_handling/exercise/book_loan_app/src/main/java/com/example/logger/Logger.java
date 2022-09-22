package com.example.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class Logger {
    private int count = 0;

    @Pointcut("within(com.example.controller.BookController*)")
    public void allMethodPointCut() {
    }

    @After("allMethodPointCut()")
    public void afterAllMethod(JoinPoint joinPoint) {
        count++;
        System.err.println("Method name: " + joinPoint.getSignature().getName() +
                " | Số lượt ghé thăm thư viện sách: " + count);
    }

    @Pointcut("execution(* com.example.controller.BookController.get*(..))")
    public void payAndBorrowMethodPointCut() {
    }

    @After("payAndBorrowMethodPointCut()")
    public void afterPayAndBorrowMethod(JoinPoint joinPoint) {
        System.err.println("Method name: " + joinPoint.getSignature().getName() + " | Time: " + LocalDateTime.now());
    }
}
