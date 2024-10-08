package com.example.InsuranceManagementSystem.controller;

import com.example.InsuranceManagementSystem.dto.PolicyHolderDTO;
import com.example.InsuranceManagementSystem.modal.PolicyHolder;
import com.example.InsuranceManagementSystem.service.PolicyHolderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policy holder")
public class PolicyHolderController {

    @Autowired
    private PolicyHolderService policyHolderService;

    @PostMapping("/add holder/{agentId}/{holderId}")
    public PolicyHolderDTO add(@Valid @RequestBody PolicyHolderDTO policyHolderDTO){
        return policyHolderService.addPHolder(policyHolderDTO);
    }

    @GetMapping("/getall")
    public List<PolicyHolder> getAllPolicyHolders(){
        return policyHolderService.getAllPolicyHolders();
    }

    @GetMapping("/get/{id}")
    public PolicyHolderDTO getById(@PathVariable long id){
        return policyHolderService.getById(id);
    }

    @PutMapping("/update/{id}")
    public PolicyHolderDTO updateData(@PathVariable long id,@Valid @RequestBody PolicyHolderDTO policyHolderDTO){
        return policyHolderService.updateData(id, policyHolderDTO);
    }

    @DeleteMapping("/delete/{id}")
    public PolicyHolderDTO removeEntry(@PathVariable long id){
        return policyHolderService.removeEntry(id);
    }
}
