package com.hackathonYarismaProjesi.hackathon.Repository;

import com.hackathonYarismaProjesi.hackathon.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<Address,String> {
    @Query("SELECT c FROM Address a inner join a.customer o where a.address_name like %:address_name%")
    public Address findAddressByName(@Param("address_name") String address_name);

}
