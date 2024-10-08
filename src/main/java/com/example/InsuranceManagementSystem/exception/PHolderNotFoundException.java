package com.example.InsuranceManagementSystem.exception;

public class PHolderNotFoundException extends RuntimeException{

    public PHolderNotFoundException(Long id) {
        super("Policyholder with ID " + id + " not found");
    }

}
