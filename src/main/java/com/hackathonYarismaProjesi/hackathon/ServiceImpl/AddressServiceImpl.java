package com.hackathonYarismaProjesi.hackathon.ServiceImpl;

import com.hackathonYarismaProjesi.hackathon.Entity.Address;
import com.hackathonYarismaProjesi.hackathon.Entity.Customer;
import com.hackathonYarismaProjesi.hackathon.Repository.AddressRepository;
import com.hackathonYarismaProjesi.hackathon.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl  implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address getAddressByName(String address_name) {
        return addressRepository.findAddressByName(address_name);
    }

    @Override
    public void deleteAddress(String address_name){
        Address existingAddress = new Address();
        existingAddress = addressRepository.findAddressByName(address_name);
        if(existingAddress != null){
            addressRepository.delete(existingAddress);
        }



    }

    @Override
    public Address updateAddress(Address address, String address_name) {
        Address existingAddress = addressRepository.findAddressByName(address_name);
        if(existingAddress != null){
            existingAddress.setAddress_name(existingAddress.getAddress_name());
            existingAddress.setCity(existingAddress.getCity());
            existingAddress.setDistrict(existingAddress.getDistrict());
            existingAddress.setCustomer(existingAddress.getCustomer());
        }
        addressRepository.save(address);

        return existingAddress;
    }


}
