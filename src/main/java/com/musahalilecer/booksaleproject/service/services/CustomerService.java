package com.musahalilecer.booksaleproject.service.services;

import com.musahalilecer.booksaleproject.dto.request.CustomerRequest;
import com.musahalilecer.booksaleproject.dto.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    List<CustomerResponse> getAllCustomers();
    CustomerResponse getCustomerById(int id);
    CustomerResponse createCustomer(CustomerRequest customerRequest);
    CustomerResponse updateCustomer(int id, CustomerRequest customerRequest);
    void deleteCustomerById(int id);
}
