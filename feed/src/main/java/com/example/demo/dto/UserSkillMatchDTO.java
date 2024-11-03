package com.example.demo.dto;

public class UserSkillMatchDTO {
    private Long user1Id;
    private String user1Username;
    private String user1Skill;
    private Long user2Id;
    private String user2Username;
    private String user2WantedSkill;
    private String user2Skill;
    private String user1WantedSkill;
    private String user2ProfilePicture;  // Add this line

    // Getters and setters for all fields
    public String getUser2ProfilePicture() {
        return user2ProfilePicture;
    }

    public void setUser2ProfilePicture(String user2ProfilePicture) {
        this.user2ProfilePicture = user2ProfilePicture;
    }

    // Getters and Setters
    public Long getUser1Id() { return user1Id; }
    public void setUser1Id(Long user1Id) { this.user1Id = user1Id; }

    public String getUser1Username() { return user1Username; }
    public void setUser1Username(String user1Username) { this.user1Username = user1Username; }

    public String getUser1Skill() { return user1Skill; }
    public void setUser1Skill(String user1Skill) { this.user1Skill = user1Skill; }

    public Long getUser2Id() { return user2Id; }
    public void setUser2Id(Long user2Id) { this.user2Id = user2Id; }

    public String getUser2Username() { return user2Username; }
    public void setUser2Username(String user2Username) { this.user2Username = user2Username; }

    public String getUser2WantedSkill() { return user2WantedSkill; }
    public void setUser2WantedSkill(String user2WantedSkill) { this.user2WantedSkill = user2WantedSkill; }

    public String getUser2Skill() { return user2Skill; }
    public void setUser2Skill(String user2Skill) { this.user2Skill = user2Skill; }

    public String getUser1WantedSkill() { return user1WantedSkill; }
    public void setUser1WantedSkill(String user1WantedSkill) { this.user1WantedSkill = user1WantedSkill; }
}
