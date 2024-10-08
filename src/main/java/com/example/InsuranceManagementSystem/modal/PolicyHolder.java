package com.example.InsuranceManagementSystem.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyHolder {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "policyHolder",cascade = CascadeType.ALL)
    private List<Policy> policies;

    @OneToMany(mappedBy = "policyHolder",cascade = CascadeType.ALL)
    private List<Address> addresses;
}
