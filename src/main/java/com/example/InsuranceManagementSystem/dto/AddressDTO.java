package com.example.InsuranceManagementSystem.dto;

import com.example.InsuranceManagementSystem.modal.PolicyHolder;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    @NotEmpty(message="street should not be empty")
    private String street;

    @NotEmpty(message="city Name should not be empty")
    private String city;

    @NotEmpty(message="state name should not be empty")
    private String state;

    @NotEmpty(message="zipcode should not be empty")
    private String zipcode;

    private PolicyHolder policyHolder;
}
