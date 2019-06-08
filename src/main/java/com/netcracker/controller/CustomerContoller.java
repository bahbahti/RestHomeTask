package com.netcracker.controller;

import com.netcracker.converter.Converter;
import com.netcracker.exception.ResourceNotFoundException;
import com.netcracker.model.Customer;
import com.netcracker.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.netcracker.constants.Contstants.*;

@RestController
@RequestMapping("/rest")
public class CustomerContoller {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    Converter converter;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Integer customerId)
            throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping("/customers")
    public String createCustomer(@Valid @RequestBody Customer customer) {
        customerRepository.save(customer);
        return converter.convertPojoToJSON(ADD_CONST);
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomerById(@PathVariable(value = "id") Integer customerId)
            throws ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

        customerRepository.delete(customer);
        return converter.convertPojoToJSON(DELETE_CONST);
    }

    @DeleteMapping("/customers")
    public String deleteAllCustomers() {
        customerRepository.deleteAll();
        return converter.convertPojoToJSON(DELETE_ALL_CONST);
    }

    @PutMapping("/customers{id}")
    public String updateCustomerById(@PathVariable(value = "id") Integer customerId, @RequestBody Customer customer)
            throws ResourceNotFoundException {
        Customer customerFromDB = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));
        customerFromDB.setCustomer_id(customerId);
        customerFromDB.setLastName(customer.getLastName());
        customerFromDB.setArea(customer.getArea());
        customerFromDB.setDiscount(customer.getDiscount());
        customerRepository.save(customerFromDB);
        return converter.convertPojoToJSON(UPDATE_CONST);
    }
}
