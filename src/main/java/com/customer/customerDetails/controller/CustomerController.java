package com.customer.customerDetails.controller;

import com.customer.customerDetails.model.Customer;
import com.customer.customerDetails.service.CustomerService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService= customerService;
    }

    @PostMapping(value = "/customer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
    {
        return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.OK);
    }
    @GetMapping(value = "/customer")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        return new ResponseEntity<>(customerService.getAllCustomer(),HttpStatus.OK);
    }
}
