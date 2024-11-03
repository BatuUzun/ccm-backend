package com.example.demo.service;

import com.example.demo.entity.UserSkill;
import com.example.demo.repository.UserSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserSkillService {

    @Autowired
    private UserSkillRepository userSkillRepository;

    public UserSkill addUserSkill(UserSkill userSkill) {
        return userSkillRepository.save(userSkill);
    }

    public List<UserSkill> getAllUserSkills() {
        return userSkillRepository.findAll();
    }

    public Optional<UserSkill> getUserSkillById(Long id) {
        return userSkillRepository.findById(id);
    }

    public void deleteUserSkill(Long id) {
        userSkillRepository.deleteById(id);
    }
    
    public List<UserSkill> getUserSkillsByUserId(Long userId) {
        return userSkillRepository.findByUserId(userId); // This method needs to be defined in the repository
    }
}
