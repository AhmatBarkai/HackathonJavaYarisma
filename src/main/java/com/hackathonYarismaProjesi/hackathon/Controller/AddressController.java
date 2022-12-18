package com.hackathonYarismaProjesi.hackathon.Controller;

import com.hackathonYarismaProjesi.hackathon.Entity.Address;
import com.hackathonYarismaProjesi.hackathon.Entity.Customer;
import com.hackathonYarismaProjesi.hackathon.Repository.AddressRepository;
import com.hackathonYarismaProjesi.hackathon.Repository.CustomerRepository;
import com.hackathonYarismaProjesi.hackathon.Response.Response;
import com.hackathonYarismaProjesi.hackathon.Service.AddressService;
import com.hackathonYarismaProjesi.hackathon.Service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CustomerService customerService;

    @PostMapping("/saveAddress/{email}")
    public ResponseEntity<Response> saveAddress(@RequestBody Address address , @PathVariable String email){
        Customer customer1 = customerService.getCustomerById(email);
        customer1.getAddresses().add(address);
        Response response =new Response();
        response.setCode("200");
        response.setMsg("Address saved with successfully");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/getAddressByName/{address_name")
    public Address addressByName(@PathVariable String address_name){
        Address address = addressRepository.findAddressByName(address_name);

        if (null != address && null != address.getAddress_name()){
            return addressRepository.findAddressByName(address.getAddress_name());
        }else {
            return null;
        }
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Response> updateAddress(@RequestBody Address address , @PathVariable String address_name){
        Response response = new Response();
        try{
            Address address1 = new Address();
            address1 = addressService.updateAddress(address,address_name);
            addressRepository.save(address);
            response.setCode("200");
            response.setMsg("address is updated successfully in the Db.");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);
        }catch (Exception e){
            response.setCode("400");
            response.setMsg("no such an address in the Db to be updated.");

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);
        }
    }


    @DeleteMapping("/deleteAddress/{address_name}")
    public ResponseEntity<Response> deleteAddress(@PathVariable String address_name){
        Response response =new Response();

        try{
            addressService.deleteAddress(address_name);
            response.setCode("200");
            response.setMsg("address is deleted successfully ");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);

        }catch (Exception e){
            response.setCode("401");
            response.setMsg("No such a address to be deleted .");
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(response);

        }
    }




}
