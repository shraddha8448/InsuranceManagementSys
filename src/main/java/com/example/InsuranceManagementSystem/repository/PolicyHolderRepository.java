package com.example.InsuranceManagementSystem.repository;

import com.example.InsuranceManagementSystem.modal.PolicyHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyHolderRepository extends JpaRepository<PolicyHolder,Long> {
}
