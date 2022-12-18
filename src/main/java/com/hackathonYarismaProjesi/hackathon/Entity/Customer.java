package com.hackathonYarismaProjesi.hackathon.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="customer")
public class Customer {
    @Id
    @Column(name="email",unique = true)
    private String email;

    @Column(name="password")
    private int password;


    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(name = "email")
    private List<Address> addresses;





}
