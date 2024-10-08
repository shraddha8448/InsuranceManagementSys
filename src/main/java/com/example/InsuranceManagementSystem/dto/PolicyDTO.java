package com.example.InsuranceManagementSystem.dto;

import com.example.InsuranceManagementSystem.modal.Agent;
import com.example.InsuranceManagementSystem.modal.Claim;
import com.example.InsuranceManagementSystem.modal.PolicyHolder;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyDTO {

    @NotNull(message="policy number should not be null")
    private long policyNumber;

    @NotEmpty(message="Policy Type should not be empty")
    private String policyType;

    private List<Claim> claims;
    private Agent agent;
    private PolicyHolder policyHolder;

}
