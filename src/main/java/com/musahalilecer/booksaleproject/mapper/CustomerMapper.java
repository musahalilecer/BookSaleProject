package com.musahalilecer.booksaleproject.mapper;

import com.musahalilecer.booksaleproject.dto.request.CustomerRequest;
import com.musahalilecer.booksaleproject.dto.response.CustomerResponse;
import com.musahalilecer.booksaleproject.model.Customer;

public class CustomerMapper {
    public static CustomerResponse toCustomerResponse(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getName(),
                customer.getSurname(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getPhone()
        );
    }
    public static Customer toCustomerEntity(CustomerRequest request) {
        return Customer.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .address(request.getAddress())
                .phone(request.getPhone())
                .build();
    }
    public static void toCustomerRequest(Customer customer, CustomerRequest customerRequest) {
        customer.setName(customerRequest.getName());
        customer.setSurname(customerRequest.getSurname());
        customer.setEmail(customerRequest.getEmail());
        customer.setAddress(customerRequest.getAddress());
        customer.setPhone(customerRequest.getPhone());

    }
}
