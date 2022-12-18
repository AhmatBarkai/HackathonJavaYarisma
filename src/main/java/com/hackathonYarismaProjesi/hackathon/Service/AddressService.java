package com.hackathonYarismaProjesi.hackathon.Service;

import com.hackathonYarismaProjesi.hackathon.Entity.Address;
import com.hackathonYarismaProjesi.hackathon.Entity.Customer;
import com.hackathonYarismaProjesi.hackathon.ServiceImpl.AddressServiceImpl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


public interface AddressService  {
    public Address saveAddress(Address address);

    public Address getAddressByName(String address_name);

    public void deleteAddress(String address_name);

    public Address updateAddress(Address address,String address_name);





}
