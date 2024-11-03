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
import com.example.demo.entity.WantedSkill;
import com.example.demo.service.WantedSkillService;

@RestController
@RequestMapping("/wanted-skills")
public class WantedController {

	@Autowired
    private WantedSkillService wantedSkillService;

    // Create or Add a new UserSkill
    @PostMapping("/add-skill")
    public WantedSkill addUserSkill(@RequestBody WantedSkill userSkill) {
        return wantedSkillService.addUserSkill(userSkill);
    }

    // Get all UserSkills
    @GetMapping("/get-skills")
    public List<WantedSkill> getAllUserSkills() {
        return wantedSkillService.getAllUserSkills();
    }

    // Delete a UserSkill by ID
    @DeleteMapping("/delete/{id}")
    public void deleteUserSkill(@PathVariable Long id) {
        wantedSkillService.deleteUserSkill(id);
    }
    
    @GetMapping("/user/{userId}")
    public List<WantedSkill> getUserSkillsByUserId(@PathVariable Long userId) {
        return wantedSkillService.getUserSkillsByUserId(userId);
    }
}
