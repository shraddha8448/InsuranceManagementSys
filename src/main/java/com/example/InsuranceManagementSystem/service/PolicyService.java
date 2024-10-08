package com.example.InsuranceManagementSystem.service;

import com.example.InsuranceManagementSystem.dto.PolicyDTO;
import com.example.InsuranceManagementSystem.modal.Policy;
import com.example.InsuranceManagementSystem.modal.PolicyHolder;

import java.util.List;

public interface PolicyService {

    PolicyDTO addPolicy(PolicyDTO policyDTO);

    List<Policy> getAllPolicies();

    PolicyDTO getPolicyById(long id);

    PolicyDTO updatePolicy(long id, PolicyDTO policyDTO);

    PolicyDTO removePolicy(long id);

    PolicyDTO assignAgent(Long policyId,Long agentId);

    PolicyDTO addingPolicyHolder(Long policyId, Long policyHolderId);
}
