package com.example.InsuranceManagementSystem.service;

import com.example.InsuranceManagementSystem.dto.ClaimDTO;
import com.example.InsuranceManagementSystem.exception.ClaimNotFoundException;
import com.example.InsuranceManagementSystem.exception.PolicyNotFoundException;
import com.example.InsuranceManagementSystem.modal.Claim;
import com.example.InsuranceManagementSystem.modal.Policy;
import com.example.InsuranceManagementSystem.repository.ClaimRepository;
import com.example.InsuranceManagementSystem.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimServiceImp implements ClaimService{

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private PolicyRepository policyRepository;

    public ClaimDTO mapToClaimDTO(Claim claim){
        ClaimDTO claimDTO = new ClaimDTO();

        claimDTO.setClaimNumber(claim.getClaimNumber());
        claimDTO.setDate(claim.getDate());
        claimDTO.setAmount(claim.getAmount());
        claimDTO.setPolicy(claim.getPolicy());
        claimDTO.setStatus(claim.getStatus());

        return  claimDTO;
    }

    public ClaimDTO addingNewClaim(ClaimDTO claimDTO,Long policyId){

        Claim claim = new Claim();
        claim.setDate(claimDTO.getDate());
        claim.setAmount(claimDTO.getAmount());
        claim.setStatus(claimDTO.getStatus());
        claim.setClaimNumber(claimDTO.getClaimNumber());
        //claim.setPolicy(claimDTO.getPolicy());

        Policy policy = policyRepository.findById(policyId)
                .orElseThrow(() -> new PolicyNotFoundException(claim.getPolicy().getPolicyId()));
        claim.setPolicy(policy);
        return mapToClaimDTO(claimRepository.save(claim));

    }

    public List<Claim> getAllClaim(){
        return claimRepository.findAll();
    }

    public ClaimDTO getClaimById(long id){
        return mapToClaimDTO(claimRepository.findById(id).orElseThrow(()-> new ClaimNotFoundException(id)));
    }

    public ClaimDTO updateClaim(long id, ClaimDTO claimDTO){
        Claim claim = claimRepository.findById(id).orElseThrow(()-> new ClaimNotFoundException(id));
        claim.setClaimNumber(claimDTO.getClaimNumber());
        claim.setAmount(claimDTO.getAmount());
        claim.setDate(claimDTO.getDate());
        claim.setStatus(claimDTO.getStatus());
        claim.setPolicy(claimDTO.getPolicy());

        return mapToClaimDTO(claimRepository.save(claim));
    }

    public ClaimDTO deleteClaim(long id){
        Claim claim = claimRepository.findById(id).orElseThrow(()->new ClaimNotFoundException(id));
        claimRepository.deleteById(id);

        return mapToClaimDTO(claim);
    }

    public ClaimDTO updateClaimStatus(long claimId , String status){
        Claim claim = claimRepository.findById(claimId).orElseThrow(()->new ClaimNotFoundException(claimId));
        claim.setStatus(status);

        return mapToClaimDTO(claimRepository.save(claim));
    }
}
