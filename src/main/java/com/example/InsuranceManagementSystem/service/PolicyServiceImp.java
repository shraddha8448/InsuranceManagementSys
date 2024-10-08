package com.example.InsuranceManagementSystem.service;

import com.example.InsuranceManagementSystem.dto.AgentDTO;
import com.example.InsuranceManagementSystem.dto.PolicyDTO;
import com.example.InsuranceManagementSystem.exception.AgentNotFoundException;
import com.example.InsuranceManagementSystem.exception.PHolderNotFoundException;
import com.example.InsuranceManagementSystem.exception.PolicyNotFoundException;
import com.example.InsuranceManagementSystem.modal.Agent;
import com.example.InsuranceManagementSystem.modal.Claim;
import com.example.InsuranceManagementSystem.modal.Policy;
import com.example.InsuranceManagementSystem.modal.PolicyHolder;
import com.example.InsuranceManagementSystem.repository.AgentRepository;
import com.example.InsuranceManagementSystem.repository.PolicyHolderRepository;
import com.example.InsuranceManagementSystem.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyServiceImp implements PolicyService{

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private PolicyHolderRepository policyHolderRepository;

    public PolicyDTO mapToPolicyDTO(Policy policy){
        PolicyDTO policyDTO = new PolicyDTO();

        policyDTO.setPolicyNumber(policy.getPolicyNumber());
        policyDTO.setPolicyType(policy.getPolicyType());
        policyDTO.setPolicyHolder(policy.getPolicyHolder());
        policyDTO.setClaims(policy.getClaims());
        policyDTO.setAgent(policy.getAgent());

        return policyDTO;
    }
    // add policy in DB
    public PolicyDTO addPolicy(PolicyDTO policyDTO){
        Policy policy = new Policy();
        policy.setPolicyNumber(policyDTO.getPolicyNumber());
        policy.setPolicyType(policyDTO.getPolicyType());
//        policy.setAgent(policyDTO.getAgent());
//        policy.setPolicyHolder(policyDTO.getPolicyHolder());
//
//        List<Claim> claims = policyDTO.getClaims();
//        claims.forEach(claim -> claim.setPolicy(policy));
//        policy.setClaims(claims);

        return mapToPolicyDTO(policyRepository.save(policy));
    }

    // assign the Agent
    public PolicyDTO assignAgent(Long policyId,Long agentId){

        if(agentId != null && policyId != null) {
            Policy policy = policyRepository.findById(policyId).orElseThrow(() -> new PolicyNotFoundException(policyId));


            Agent agent = agentRepository.findById(agentId).orElseThrow(() -> new AgentNotFoundException(agentId));
            policy.setAgent(agent);

            return mapToPolicyDTO(policyRepository.save(policy));
        }
        return null;
    }

    public PolicyDTO addingPolicyHolder(Long policyId, Long policyHolderId){

        if(policyId != null && policyHolderId != null){
            Policy policy = policyRepository.findById(policyId).orElseThrow(()->new PolicyNotFoundException(policyId));

            PolicyHolder policyHolder = policyHolderRepository.findById(policyHolderId).orElseThrow(()->new PHolderNotFoundException(policyHolderId));
            policy.setPolicyHolder(policyHolder);

            return mapToPolicyDTO(policyRepository.save(policy));
        }
        return null;
    }

    // Retrive all the policies
    public List<Policy> getAllPolicies(){
        return policyRepository.findAll();
    }

    // get policy by Id
    public PolicyDTO getPolicyById(long id){
        return mapToPolicyDTO(policyRepository.findById(id).orElseThrow(()->new PolicyNotFoundException(id)));
    }

    // update policy using id
    public PolicyDTO updatePolicy(long id, PolicyDTO policyDTO){

        Policy policy = policyRepository.findById(id).orElseThrow(()->new PolicyNotFoundException(id));
        policy.setPolicyNumber(policyDTO.getPolicyNumber());
        policy.setPolicyType(policyDTO.getPolicyType());
        policy.setClaims(policyDTO.getClaims());
        policy.setPolicyHolder(policyDTO.getPolicyHolder());
        policy.setAgent(policyDTO.getAgent());

        return mapToPolicyDTO(policyRepository.save(policy));
    }

    // remove policy using id
    public PolicyDTO removePolicy(long id){
        Policy policy = policyRepository.findById(id).orElseThrow(()->new PolicyNotFoundException(id));

        policyRepository.deleteById(id);
        return mapToPolicyDTO(policy);
    }

}
