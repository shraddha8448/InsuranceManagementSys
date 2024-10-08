package com.example.InsuranceManagementSystem.service;

import com.example.InsuranceManagementSystem.dto.PolicyHolderDTO;
import com.example.InsuranceManagementSystem.exception.PHolderNotFoundException;
import com.example.InsuranceManagementSystem.modal.Address;
import com.example.InsuranceManagementSystem.modal.PolicyHolder;
import com.example.InsuranceManagementSystem.repository.PolicyHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyHolderSerImp implements PolicyHolderService {

    @Autowired
    private PolicyHolderRepository policyHolderRepository;

    public PolicyHolderDTO mapTOPolicyHolderDTO(PolicyHolder policyHolder){
        PolicyHolderDTO policyHolderDTO = new PolicyHolderDTO();
        policyHolderDTO.setPolicies(policyHolder.getPolicies());
        policyHolderDTO.setName(policyHolder.getName());
        policyHolderDTO.setEmail(policyHolder.getEmail());
        policyHolderDTO.setAddresses(policyHolder.getAddresses());
        return policyHolderDTO;
    }

    public PolicyHolderDTO addPHolder(PolicyHolderDTO policyHolderDTO){
        PolicyHolder policyHolder = new PolicyHolder();

        policyHolder.setName(policyHolderDTO.getName());
        policyHolder.setEmail(policyHolderDTO.getEmail());

        List<Address> addresses = policyHolderDTO.getAddresses();
        if(addresses!= null){
            addresses.forEach(address -> address.setPolicyHolder(policyHolder));
            policyHolder.setAddresses(addresses);
        }

        return mapTOPolicyHolderDTO(policyHolderRepository.save(policyHolder));
    }


    public List<PolicyHolder> getAllPolicyHolders(){
        return policyHolderRepository.findAll();
    }

    public PolicyHolderDTO getById(long id){
        PolicyHolder policyHolder = policyHolderRepository.findById(id).orElseThrow(()->new PHolderNotFoundException(id));

        return mapTOPolicyHolderDTO(policyHolder);
    }

    public PolicyHolderDTO updateData(long id, PolicyHolderDTO policyHolderDTO){
        PolicyHolder policyHolder = policyHolderRepository.findById(id).orElseThrow(()-> new PHolderNotFoundException(id));

        policyHolder.setName(policyHolderDTO.getName());
        policyHolder.setEmail(policyHolderDTO.getEmail());
        policyHolder.setPolicies(policyHolderDTO.getPolicies());
        policyHolder.setAddresses(policyHolderDTO.getAddresses());

        return mapTOPolicyHolderDTO(policyHolderRepository.save(policyHolder));
    }

    public PolicyHolderDTO removeEntry(long id){
        PolicyHolder policyHolder = policyHolderRepository.findById(id).orElseThrow(()-> new PHolderNotFoundException(id));
        policyHolderRepository.deleteById(id);

        return mapTOPolicyHolderDTO(policyHolder);
    }
}
