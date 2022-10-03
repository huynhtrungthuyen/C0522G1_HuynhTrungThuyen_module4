package com.example.dto;

import com.example.model.customer.Customer;
import com.example.model.employee.Employee;
import com.example.model.facility.Facility;

public interface IContractDto {
    String getContractId();
    String getStartDate();
    String getEndDate();
    String getDeposit();
    String getTotalMoney();
    String getEmployeeName();
    String getCustomerName();
    String getFacilityName();
}
