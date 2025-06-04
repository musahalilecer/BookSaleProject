package com.musahalilecer.booksaleproject.service.serviceImp;

import com.musahalilecer.booksaleproject.dto.request.CustomerRequest;
import com.musahalilecer.booksaleproject.dto.response.CustomerResponse;
import com.musahalilecer.booksaleproject.mapper.CustomerMapper;
import com.musahalilecer.booksaleproject.model.Customer;
import com.musahalilecer.booksaleproject.repository.CustomerRepository;
import com.musahalilecer.booksaleproject.service.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerResponse> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(CustomerMapper::toCustomerResponse).collect(Collectors.toList());
    }

    @Override
    public CustomerResponse getCustomerById(int id) {
        return customerRepository
                .findById(id)
                .map(CustomerMapper::toCustomerResponse)
                .orElse(null);
    }

    @Override
    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        Customer newCustomer = CustomerMapper.toCustomerEntity(customerRequest);
        Customer savedCustomer = customerRepository.save(newCustomer);
        return CustomerMapper.toCustomerResponse(savedCustomer);
    }

    @Override
    public CustomerResponse updateCustomer(int id, CustomerRequest customerRequest) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);
        if (existingCustomer == null) {
            return null;
        }
        CustomerMapper.toCustomerRequest(existingCustomer, customerRequest);
        Customer updatedCustomer = customerRepository.save(existingCustomer);
        return CustomerMapper.toCustomerResponse(updatedCustomer);
    }

    @Override
    public void deleteCustomerById(int id) {
        customerRepository.deleteById(id);
    }
}
