package com.example.demo.service;

import com.example.demo.dto.UserSkillMatchDTO;
import com.example.demo.repository.UserSkillRepositoryCustom;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserSkillService {

    private final UserSkillRepositoryCustom userSkillRepository;

    public UserSkillService(UserSkillRepositoryCustom userSkillRepository) {
        this.userSkillRepository = userSkillRepository;
    }

    public List<UserSkillMatchDTO> getMutualSkillMatches(Long user1Id) {
        return userSkillRepository.findMutualSkillMatches(user1Id);
    }
}
