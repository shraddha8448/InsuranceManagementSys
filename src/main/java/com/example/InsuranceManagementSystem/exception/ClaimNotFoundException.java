package com.example.InsuranceManagementSystem.exception;

public class ClaimNotFoundException extends RuntimeException{
    public ClaimNotFoundException(Long id) {
        super("Claim with ID " + id + " not found");
    }

}
