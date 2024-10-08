package com.example.InsuranceManagementSystem.repository;

import com.example.InsuranceManagementSystem.modal.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent,Long> {
}
