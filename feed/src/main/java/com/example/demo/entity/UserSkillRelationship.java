package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_skill_relationship")
public class UserSkillRelationship {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "userProfileId1", nullable = false)
    private Long userProfileId1;
    
    @Column(name = "userSkill1", nullable = false)
    private String userSkill1;
    
    @Column(name = "userProfileId2", nullable = false)
    private Long userProfileId2;
    
    @Column(name = "userSkill2", nullable = false)
    private String userSkill2;
    
    @Column(name = "isAccepted")
    private Boolean isAccepted;

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

	public Boolean getIsAccepted() {
		return isAccepted;
	}

	public void setIsAccepted(Boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public UserSkillRelationship(Long userProfileId1, String userSkill1, Long userProfileId2, String userSkill2,
			Boolean isAccepted) {
		super();
		this.userProfileId1 = userProfileId1;
		this.userSkill1 = userSkill1;
		this.userProfileId2 = userProfileId2;
		this.userSkill2 = userSkill2;
		this.isAccepted = isAccepted;
	}

	public UserSkillRelationship() {
		super();
	}

    // Getters and Setters
    // ...
    
    
}