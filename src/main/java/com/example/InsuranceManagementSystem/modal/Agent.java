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
public class Agent {

    @Id
    @GeneratedValue
    private long agentId;

    private String agentName;

    @Column(unique = true)
    private String agentEmail;

    @OneToMany(mappedBy = "agent",cascade = CascadeType.ALL)
    private List<Policy> policies;
}
