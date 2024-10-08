package com.example.InsuranceManagementSystem.repository;

import com.example.InsuranceManagementSystem.modal.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository<Claim,Long> {
}
