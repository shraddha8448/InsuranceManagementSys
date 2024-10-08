package com.example.InsuranceManagementSystem.exception;


public class PolicyNotFoundException extends RuntimeException{
    public PolicyNotFoundException(Long id) {
        super("Policy with ID " + id + " not found");
    }

}
