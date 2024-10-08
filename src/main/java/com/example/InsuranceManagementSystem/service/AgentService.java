package com.example.InsuranceManagementSystem.service;

import com.example.InsuranceManagementSystem.dto.AgentDTO;
import com.example.InsuranceManagementSystem.modal.Agent;

import java.util.List;

public interface AgentService {

    AgentDTO addNewAgent(AgentDTO agentDTO);

    List<Agent> getAllAgents();

    AgentDTO getAgentById(long id);

    AgentDTO updateAgentInfo(long id, AgentDTO agentDTO);

    AgentDTO removeAgent(long id);
}
