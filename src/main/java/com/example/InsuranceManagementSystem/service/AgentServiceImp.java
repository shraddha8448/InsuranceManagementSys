package com.example.InsuranceManagementSystem.service;

import com.example.InsuranceManagementSystem.dto.AgentDTO;
import com.example.InsuranceManagementSystem.exception.AgentNotFoundException;
import com.example.InsuranceManagementSystem.modal.Agent;
import com.example.InsuranceManagementSystem.modal.Claim;
import com.example.InsuranceManagementSystem.modal.Policy;
import com.example.InsuranceManagementSystem.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImp implements AgentService{

    @Autowired
    private AgentRepository agentRepository;

    public AgentDTO addNewAgent(AgentDTO agentDTO){
        Agent agent = new Agent();

        agent.setAgentName(agentDTO.getAgentName());
        agent.setAgentEmail(agentDTO.getAgentEmail());

        List<Policy> policies = agentDTO.getPolicies();

        if(policies!=null){
            policies.forEach(policy -> {
                policy.setAgent(agent);
                List<Claim> claims =policy.getClaims();
                if(claims != null){
                    claims.forEach(claim -> claim.setPolicy(policy));
                    policy.setClaims(claims);
                }
                agent.setPolicies(policies);

            });
        }


        agent.setPolicies(policies);

        return mapToAgentDTO(agentRepository.save(agent));
    }

    public AgentDTO mapToAgentDTO(Agent agent){
        AgentDTO agentDTO = new AgentDTO();

        agentDTO.setAgentName(agent.getAgentName());
        agentDTO.setAgentEmail(agent.getAgentEmail());
        agentDTO.setPolicies(agent.getPolicies());

        return agentDTO;
    }

    public List<Agent> getAllAgents(){
        return agentRepository.findAll();
    }

    public AgentDTO getAgentById(long id){
        return mapToAgentDTO(agentRepository.findById(id).orElseThrow(()->new AgentNotFoundException(id)));
    }

    public AgentDTO updateAgentInfo(long id, AgentDTO agentDTO){
        Agent agent = agentRepository.findById(id).orElseThrow(()->new AgentNotFoundException(id));

        agent.setAgentName(agentDTO.getAgentName());
        agent.setAgentEmail(agentDTO.getAgentEmail());
        agent.setPolicies(agentDTO.getPolicies());

        agentRepository.save(agent);
        return mapToAgentDTO(agent);
    }

    public AgentDTO removeAgent(long id){
        Agent agent = agentRepository.findById(id).orElseThrow(()->new AgentNotFoundException(id));
        agentRepository.deleteById(id);
        return mapToAgentDTO(agent);
    }

}
