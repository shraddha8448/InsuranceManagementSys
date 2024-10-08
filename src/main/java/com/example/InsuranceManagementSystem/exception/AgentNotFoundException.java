package com.example.InsuranceManagementSystem.exception;

public class AgentNotFoundException extends RuntimeException{
    public AgentNotFoundException(Long id) {
        super("Agent with ID " + id + " not found");
    }

}