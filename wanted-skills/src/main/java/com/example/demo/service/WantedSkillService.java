package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.WantedSkill;
import com.example.demo.repository.WantedSkillRepository;

@Service
public class WantedSkillService {

    @Autowired
    private WantedSkillRepository userSkillRepository;

    public WantedSkill addUserSkill(WantedSkill userSkill) {
        return userSkillRepository.save(userSkill);
    }

    public List<WantedSkill> getAllUserSkills() {
        return userSkillRepository.findAll();
    }

    public Optional<WantedSkill> getUserSkillById(Long id) {
        return userSkillRepository.findById(id);
    }

    public void deleteUserSkill(Long id) {
        userSkillRepository.deleteById(id);
    }
    
    public List<WantedSkill> getUserSkillsByUserId(Long userId) {
        return userSkillRepository.findByUserId(userId); // This method needs to be defined in the repository
    }
}
