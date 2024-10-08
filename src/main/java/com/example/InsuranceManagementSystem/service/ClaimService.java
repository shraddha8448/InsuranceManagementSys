package com.example.InsuranceManagementSystem.service;

import com.example.InsuranceManagementSystem.dto.ClaimDTO;
import com.example.InsuranceManagementSystem.modal.Claim;

import java.util.List;

public interface ClaimService {

    ClaimDTO addingNewClaim(ClaimDTO claimDTO,Long policyId);

    List<Claim> getAllClaim();

    ClaimDTO getClaimById(long id);

    ClaimDTO updateClaim(long id, ClaimDTO claimDTO);

    ClaimDTO deleteClaim(long id);

    ClaimDTO updateClaimStatus(long claimId , String status);
}
