package com.example.InsuranceManagementSystem.dto;

import com.example.InsuranceManagementSystem.modal.Policy;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimDTO {

    @NotEmpty(message="claim number should not be empty")
    private String claimNumber;

    @PastOrPresent(message = "date must be past or present")
    private LocalDate date;

    @NotNull(message="amount should not be null")
    private Double amount;

    @NotEmpty(message="status should not be empty")
    private String status;

    private Policy policy;

}
