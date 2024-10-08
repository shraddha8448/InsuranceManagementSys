package com.example.InsuranceManagementSystem.repository;

import com.example.InsuranceManagementSystem.modal.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
