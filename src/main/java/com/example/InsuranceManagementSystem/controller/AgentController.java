package com.example.InsuranceManagementSystem.controller;

import com.example.InsuranceManagementSystem.dto.AgentDTO;
import com.example.InsuranceManagementSystem.modal.Agent;
import com.example.InsuranceManagementSystem.service.AgentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agent")
public class AgentController {

    @Autowired
    private AgentService agentServiceObj;

    @PostMapping("/add agent")
    public AgentDTO addNewAgent(@Valid @RequestBody AgentDTO agentDTO){
        return agentServiceObj.addNewAgent(agentDTO);
    }

    @GetMapping("/")
    public String getAllAgent(){
        return "Welcome in agent controller";
    }
    @GetMapping("/get all")
    public List<Agent> getAllAgent(){
        return agentServiceObj.getAllAgents();
    }

    @GetMapping("/get/{id}")
    public AgentDTO getAgentById(@PathVariable long id){
        return agentServiceObj.getAgentById(id);
    }

    @PutMapping("/update/{id}")
    public AgentDTO updateAgent(@PathVariable long id, @Valid @RequestBody AgentDTO agentDTO){
        return agentServiceObj.updateAgentInfo(id,agentDTO);
    }

    @DeleteMapping("/delete/{id}")
    public AgentDTO removeAgent(@PathVariable long id){
        return agentServiceObj.removeAgent(id);
    }
}
