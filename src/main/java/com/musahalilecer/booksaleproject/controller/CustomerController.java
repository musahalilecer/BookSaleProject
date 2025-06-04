package com.musahalilecer.booksaleproject.controller;

import com.musahalilecer.booksaleproject.dto.request.CustomerRequest;
import com.musahalilecer.booksaleproject.dto.response.CustomerResponse;
import com.musahalilecer.booksaleproject.model.Customer;
import com.musahalilecer.booksaleproject.service.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable int id) {
        try{
            CustomerResponse newCustomer = customerService.getCustomerById(id);
            if(newCustomer != null){
                return ResponseEntity.ok(newCustomer);
            }
            else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest customerRequest) {
        try{
            CustomerResponse newCustomer = customerService.createCustomer(customerRequest);
            if(newCustomer == null){
                return ResponseEntity.ok(newCustomer);
            }
            else {
                return ResponseEntity.badRequest().body(newCustomer);
            }
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable int id, @RequestBody CustomerRequest customerRequest) {
        try{
            CustomerResponse updatedCustomer = customerService.getCustomerById(id);
            if(updatedCustomer == null) {
                return ResponseEntity.notFound().build();
            }
            else {
                updatedCustomer.setName(customerRequest.getName());
                updatedCustomer.setSurname(customerRequest.getSurname());
                updatedCustomer.setAddress(customerRequest.getAddress());
                updatedCustomer.setPhone(customerRequest.getPhone());
                updatedCustomer.setEmail(customerRequest.getEmail());
                return ResponseEntity.ok(updatedCustomer);
            }
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id) {
        if(customerService.getCustomerById(id) != null) {
            customerService.deleteCustomerById(id);
        }
        else {
            System.out.println("not found ");
        }
    }
}