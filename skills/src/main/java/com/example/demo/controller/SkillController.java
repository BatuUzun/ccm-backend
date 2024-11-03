package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.UserSkill;
import com.example.demo.service.UserSkillService;

@RestController
@RequestMapping("/skills")
public class SkillController {

	@Autowired
    private UserSkillService userSkillService;

    // Create or Add a new UserSkill
    @PostMapping("/add-skill")
    public UserSkill addUserSkill(@RequestBody UserSkill userSkill) {
        return userSkillService.addUserSkill(userSkill);
    }

    // Get all UserSkills
    @GetMapping("/get-skills")
    public List<UserSkill> getAllUserSkills() {
        return userSkillService.getAllUserSkills();
    }

    // Delete a UserSkill by ID
    @DeleteMapping("/delete/{id}")
    public void deleteUserSkill(@PathVariable Long id) {
        userSkillService.deleteUserSkill(id);
    }
    
    @GetMapping("/user/{userId}")
    public List<UserSkill> getUserSkillsByUserId(@PathVariable Long userId) {
        return userSkillService.getUserSkillsByUserId(userId);
    }
}
