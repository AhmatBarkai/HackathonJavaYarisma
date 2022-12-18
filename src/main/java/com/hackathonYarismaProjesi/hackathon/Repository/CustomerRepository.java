package com.hackathonYarismaProjesi.hackathon.Repository;

import com.hackathonYarismaProjesi.hackathon.Entity.Address;
import com.hackathonYarismaProjesi.hackathon.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer,String> {
    @Query("SELECT c FROM Customer c inner join c.addresses o where c.email like %:email%")
    public Customer findCustomerByEmail(@Param("email") String email);

}
