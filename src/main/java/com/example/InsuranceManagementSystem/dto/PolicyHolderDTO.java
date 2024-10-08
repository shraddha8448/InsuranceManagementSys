package com.example.InsuranceManagementSystem.dto;

import com.example.InsuranceManagementSystem.modal.Address;
import com.example.InsuranceManagementSystem.modal.Policy;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyHolderDTO {

    @NotEmpty(message="Policyholder Name should not be empty")
    private String name;

    @Email(message = "Invalid Email")
    private String email;


    private List<Policy> policies;
    private List<Address> addresses;
}
