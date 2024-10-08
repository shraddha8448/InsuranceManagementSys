package com.example.InsuranceManagementSystem.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue
    private long addressId;

    private String street;
    private String city;
    private String state;
    private String zipcode;

    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnore
    private PolicyHolder policyHolder;
}
