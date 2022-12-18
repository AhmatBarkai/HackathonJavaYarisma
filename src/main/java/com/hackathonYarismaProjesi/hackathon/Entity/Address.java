package com.hackathonYarismaProjesi.hackathon.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
@Table(name="address")
public class Address {

    @Id
    @Column(name="address_name",unique = true)
    private String address_name;

    @Column(name="city")
    private String city;

    @Column(name="district")
    private String district;



    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "email",referencedColumnName = "email" )
    @OnDelete( action = OnDeleteAction.CASCADE )
    private Customer customer;






}
