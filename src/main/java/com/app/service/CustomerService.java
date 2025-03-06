package com.app.service;

import com.app.entity.Customer;
import com.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int id) {
        Optional<Customer> cus = customerRepository.findById(id);
        if(cus.isPresent()){
            return cus.get();
        }
        return null;
    }

    public Customer updateCustomer(int id,Customer customer){
        Optional<Customer> cus = customerRepository.findById(id);

        if(cus.isPresent()){
            Customer existingCus = cus.get();
            existingCus.setCustomerName(customer.getCustomerName());
            existingCus.setCustomerAddress(customer.getCustomerAddress());
            existingCus.setCustomerTel(customer.getCustomerTel());
            customerRepository.save(existingCus);
            return existingCus;
        }
        return customer;
    }

    public Customer deleteCustomer(int id){
        customerRepository.deleteById(id);
        return null;
    }
}
