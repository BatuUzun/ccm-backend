package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserSkillMatchDTO;
import com.example.demo.dto.UserSkillRelationshipRequest;
import com.example.demo.entity.UserSkillRelationship;
import com.example.demo.service.UserSkillRelationshipService;
import com.example.demo.service.UserSkillService;

@RestController
@RequestMapping("/feed")
public class UserSkillController {

    private final UserSkillService userSkillService;
    
    @Autowired
    private UserSkillRelationshipService userSkillRelationshipService;


    public UserSkillController(UserSkillService userSkillService) {
        this.userSkillService = userSkillService;
    }

    @GetMapping("/mutual-skills")
    public List<UserSkillMatchDTO> getMutualSkills(@RequestParam Long userId) {
        return userSkillService.getMutualSkillMatches(userId);
    }
    


    @PostMapping("/add-relationship")
    public ResponseEntity<UserSkillRelationship> addRelationship(
            @RequestBody UserSkillRelationshipRequest request) { // Change to use request body
        
        UserSkillRelationship relationship = userSkillRelationshipService.addRelationship(
                request.getUserProfileId1(),
                request.getUserSkill1(),
                request.getUserProfileId2(),
                request.getUserSkill2()
        );
        return ResponseEntity.ok(relationship);
    }
}
