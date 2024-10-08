package com.example.InsuranceManagementSystem.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Claim {

    @Id
    @GeneratedValue
    private long claimId;

    @Column(unique = true)
    private String claimNumber;

    private LocalDate date;
    private Double amount;
    private String status;

    @ManyToOne
    @JoinColumn(name = "policyId")
    @JsonIgnore
    private Policy policy;

}
