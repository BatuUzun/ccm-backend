package com.example.demo.dto;

public class UserSkillRelationshipRequest {
    private Long userProfileId1;
    private String userSkill1;
    private Long userProfileId2;
    private String userSkill2;

    // Getters and Setters
    public Long getUserProfileId1() {
        return userProfileId1;
    }

    public void setUserProfileId1(Long userProfileId1) {
        this.userProfileId1 = userProfileId1;
    }

    public String getUserSkill1() {
        return userSkill1;
    }

    public void setUserSkill1(String userSkill1) {
        this.userSkill1 = userSkill1;
    }

    public Long getUserProfileId2() {
        return userProfileId2;
    }

    public void setUserProfileId2(Long userProfileId2) {
        this.userProfileId2 = userProfileId2;
    }

    public String getUserSkill2() {
        return userSkill2;
    }

    public void setUserSkill2(String userSkill2) {
        this.userSkill2 = userSkill2;
    }
}