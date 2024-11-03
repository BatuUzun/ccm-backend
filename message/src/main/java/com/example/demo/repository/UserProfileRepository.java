package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    @Query("SELECT u.profilePicture FROM UserProfile u WHERE u.id = :userId")
    String findProfilePictureByUserId(@Param("userId") Long userId);
    
    @Query("SELECT u.username FROM UserProfile u WHERE u.id = :userId")
    String findUsernameByUserId(@Param("userId") Long userId);
}
