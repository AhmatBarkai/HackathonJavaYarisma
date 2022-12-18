package com.hackathonYarismaProjesi.hackathon.Service;

import com.hackathonYarismaProjesi.hackathon.Entity.Customer;
import org.springframework.stereotype.Service;


public interface CustomerService {
    public Customer saveCustomer(Customer customer);
    public Customer getCustomerById(String email);
    public Customer getCustomerByEmail(String email);
    public Customer updateCustomer(String email,Customer customer);
    public void deleteCustomer(String email);

    void delete(String email);
}

