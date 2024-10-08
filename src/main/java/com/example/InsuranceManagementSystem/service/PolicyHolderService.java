package com.example.InsuranceManagementSystem.service;

import com.example.InsuranceManagementSystem.dto.PolicyHolderDTO;
import com.example.InsuranceManagementSystem.modal.PolicyHolder;

import java.util.List;

public interface PolicyHolderService {

    PolicyHolderDTO addPHolder(PolicyHolderDTO policyHolderDTO);

    List<PolicyHolder> getAllPolicyHolders();

    PolicyHolderDTO getById(long id);

    PolicyHolderDTO updateData(long id, PolicyHolderDTO policyHolderDTO);

    PolicyHolderDTO removeEntry(long id);
}
