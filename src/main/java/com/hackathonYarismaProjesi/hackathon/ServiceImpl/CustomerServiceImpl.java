package com.hackathonYarismaProjesi.hackathon.ServiceImpl;

import com.hackathonYarismaProjesi.hackathon.Entity.Customer;
import com.hackathonYarismaProjesi.hackathon.Repository.CustomerRepository;
import com.hackathonYarismaProjesi.hackathon.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(String email) {
        return customerRepository.findById(email).get();
    }

    public Customer getCustomerByEmail(String email){
        return customerRepository.findCustomerByEmail(email);
    }

    @Override
    public Customer updateCustomer(String email, Customer customer) {
        Customer existingCustomer = customerRepository.findById(email).get();
        if(existingCustomer!=null){
            existingCustomer.setAddresses(existingCustomer.getAddresses());
            existingCustomer.setEmail(existingCustomer.getEmail());
            existingCustomer.setPassword(existingCustomer.getPassword());
            existingCustomer.setAddresses(existingCustomer.getAddresses());
        }
        customerRepository.save(existingCustomer);
        return existingCustomer;

    }

    @Override
    public void deleteCustomer(String email) {
        Customer existingCustomer = new Customer();

        existingCustomer = customerRepository.findCustomerByEmail(email);

        if(existingCustomer!=null){
            customerRepository.delete(existingCustomer);
        }

    }

    @Override
    public void delete(String email) {
        Customer existingCustomer = new Customer();
        existingCustomer = customerRepository.findCustomerByEmail(email);

    if(existingCustomer!=null){
        customerRepository.delete(existingCustomer);
    }
 }


}
