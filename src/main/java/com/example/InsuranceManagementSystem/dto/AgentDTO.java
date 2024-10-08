package com.example.InsuranceManagementSystem.dto;

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
public class AgentDTO {

    @NotEmpty(message="Agent Name should not be empty")
    private String agentName;

    @Email(message = "Invalid agent Email")

    private String agentEmail;

    private List<Policy> policies;
}
