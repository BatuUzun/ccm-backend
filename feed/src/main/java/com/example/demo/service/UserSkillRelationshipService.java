package com.example.demo.service;

import com.example.demo.entity.UserSkillRelationship;
import com.example.demo.repository.UserSkillRelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSkillRelationshipService {

    @Autowired
    private UserSkillRelationshipRepository userSkillRelationshipRepository;

    public UserSkillRelationship addRelationship(Long userProfileId1, String userSkill1, Long userProfileId2, String userSkill2) {
        UserSkillRelationship relationship = new UserSkillRelationship();
        relationship.setUserProfileId1(userProfileId1);
        relationship.setUserSkill1(userSkill1);
        relationship.setUserProfileId2(userProfileId2);
        relationship.setUserSkill2(userSkill2);
        relationship.setIsAccepted(null); // Set to null by default
        return userSkillRelationshipRepository.save(relationship);
    }
}
