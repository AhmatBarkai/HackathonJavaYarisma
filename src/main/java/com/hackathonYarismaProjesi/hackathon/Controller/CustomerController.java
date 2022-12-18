package com.hackathonYarismaProjesi.hackathon.Controller;


import com.hackathonYarismaProjesi.hackathon.Entity.Customer;
import com.hackathonYarismaProjesi.hackathon.Repository.CustomerRepository;
import com.hackathonYarismaProjesi.hackathon.Response.Response;
import com.hackathonYarismaProjesi.hackathon.Service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/saveCustomer")
    public ResponseEntity<Response> saveCustomer(@RequestBody Customer customer){

        String customer_mail = customer.getEmail();

            customerService.saveCustomer(customer);
            Response response = new Response();
            response.setCode("200");
            response.setMsg("Customer with "+customer_mail+" Email saved with successfully ");

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(response);
    }
    @GetMapping("/customerByEmail/{email}")
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email){
        Customer customer = new Customer();
        customer = customerService.getCustomerByEmail(email);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customer);
    }

    @PutMapping("/updateCustomer/{email}")
    public ResponseEntity<Response> updateEmployee(@RequestBody Customer customer , @PathVariable String email) {

        Response response = new Response();
        try {
            Customer customer1 = new Customer();
            customer1 = customerService.updateCustomer(email, customer);
            customerRepository.save(customer);

            response.setCode("200");
            response.setMsg("Employee is updated successfully in the Db.");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);
        } catch (Exception e) {
            response.setCode("400");
            response.setMsg("no such an employee in the Db to be updated.");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);
        }
    }

    @DeleteMapping("/deleteACustomer/{email}")
    public ResponseEntity<Response> deleteOneCompany(@PathVariable String email){
        Response response =new Response();

        try{
            customerService.deleteCustomer(email);
            response.setCode("200");
            response.setMsg("customer is deleted successfully ");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);

        }catch (Exception e){
            response.setCode("401");
            response.setMsg("No such a customer to be deleted .");
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(response);

        }
    }

}
