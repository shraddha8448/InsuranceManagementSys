package com.example.InsuranceManagementSystem.repository;

import com.example.InsuranceManagementSystem.modal.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends JpaRepository<Policy,Long> {
}
