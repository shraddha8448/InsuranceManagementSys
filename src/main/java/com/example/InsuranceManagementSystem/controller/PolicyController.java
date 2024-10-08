package com.example.InsuranceManagementSystem.controller;

import com.example.InsuranceManagementSystem.dto.PolicyDTO;
import com.example.InsuranceManagementSystem.modal.Policy;
import com.example.InsuranceManagementSystem.modal.PolicyHolder;
import com.example.InsuranceManagementSystem.service.PolicyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Policy")
public class PolicyController {

    @Autowired
    private PolicyService policyServiceObj;

    @PostMapping("/add policy")
    public PolicyDTO addNewPolicy(@Valid @RequestBody PolicyDTO policyDTO){
        return policyServiceObj.addPolicy(policyDTO);
    }

    @GetMapping("/get all")
    public List<Policy> getAllPolicies(){
        return policyServiceObj.getAllPolicies();
    }

    @GetMapping("/get/{id}")
    public PolicyDTO getPolicyById(@PathVariable long id){
        return policyServiceObj.getPolicyById(id);
    }

    @PutMapping("/update/{id}")
    public PolicyDTO updatePolicy(@PathVariable long id, @Valid @RequestBody PolicyDTO policyDTO){
        return policyServiceObj.updatePolicy(id,policyDTO);
    }

    @DeleteMapping("/delete/{id}")
    public PolicyDTO removePolicy(@PathVariable long id){
        return policyServiceObj.removePolicy(id);
    }

    @PutMapping("/assign agent/{policyId}/{agentId}")
    public PolicyDTO assignAgent(@PathVariable Long policyId,@PathVariable Long agentId){
        return  policyServiceObj.assignAgent(policyId,agentId);
    }

    @PutMapping("/add holder/{policyId}/{policyHolderId}")
    public PolicyDTO addPolicyHolder(@PathVariable Long policyId,@PathVariable Long policyHolderId){
        return policyServiceObj.addingPolicyHolder(policyId,policyHolderId);
    }
}
