package com.app.controller;

import com.app.entity.Customer;
import com.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path ="/customers")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }
    //localhost:8080/customer-micro/customers

    @GetMapping(path = "/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }
    //localhost:8080/customer-micro/customers

    @GetMapping(path ="/customers/{id}")
    public Customer getCustomerById(@PathVariable int id){
        return customerService.getCustomerById(id);
    }
    //localhost:8080/customer-micro/customers/1

    @PutMapping(path="/customers/{id}")
    public Customer updateCustomer(@PathVariable int id,@RequestBody Customer customer){
        return customerService.updateCustomer(id,customer);
    }
    //localhost:8080/customer-micro/customers/1


    @DeleteMapping(path ="/customers/{id}")
    public Customer deleteCustomer(@PathVariable int id){
        return customerService.deleteCustomer(id);
    }
    //localhost:8080/customer-micro/customers/1

    //login
    @GetMapping(path="/customers", params={"name", "tel"})
    public ResponseEntity<Customer> customerLogin(@RequestParam String name, @RequestParam int tel) {
        Customer customer = customerService.customerLogin(name, tel);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    //localhost:8080/customer-micro/customers?name=uvindu&tel=1234567890

}
