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
public class Policy {

    @Id
    @GeneratedValue
    private long policyId;

    @Column(unique = true)
    private long policyNumber;

    private String policyType;

    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    private List<Claim> claims;

    @ManyToOne
    @JoinColumn(name="agentId")
    @JsonIgnore
    private Agent agent;

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnore
    private PolicyHolder policyHolder;

}
