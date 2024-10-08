package com.example.InsuranceManagementSystem.controller;

import com.example.InsuranceManagementSystem.dto.ClaimDTO;
import com.example.InsuranceManagementSystem.modal.Claim;
import com.example.InsuranceManagementSystem.service.ClaimService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("claim")
public class ClaimController {

    @Autowired
    private ClaimService claimServiceObj;

    @PostMapping("/add/{policyId}")
    public ClaimDTO addingNewClaim(@Valid @RequestBody ClaimDTO claimDTO,@PathVariable Long policyId){
        return claimServiceObj.addingNewClaim(claimDTO,policyId);
    }

    @GetMapping("/get all")
    public List<Claim> getAllClaims(){
        return claimServiceObj.getAllClaim();
    }

    @GetMapping("/get/{id}")
    public ClaimDTO getClaimById(@PathVariable long id){
        return claimServiceObj.getClaimById(id);
    }

    @PutMapping("/update/{id}")
    public ClaimDTO updateClaim(@PathVariable long id, @Valid @RequestBody ClaimDTO claimDTO){
        return claimServiceObj.updateClaim(id,claimDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ClaimDTO deleteClaim(@PathVariable long id){
        return claimServiceObj.deleteClaim(id);
    }

    @PutMapping("/update status/{claimId}/{status}")
    public ClaimDTO updateClaimStatus(@PathVariable long claimId , @PathVariable String status){
        return claimServiceObj.updateClaimStatus(claimId,status);
    }
}
