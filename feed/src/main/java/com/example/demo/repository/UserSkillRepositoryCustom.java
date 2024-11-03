package com.example.demo.repository;

import com.example.demo.dto.UserSkillMatchDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class UserSkillRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public List<UserSkillMatchDTO> findMutualSkillMatches(Long user1Id) {
        String query = """
            SELECT 
                u1.id AS user1Id, 
                up1.username AS user1Username,
                us.skill_name AS user1Skill,
                u2.id AS user2Id, 
                up2.username AS user2Username,
                ws.skill_name AS user2WantedSkill,
                us2.skill_name AS user2Skill,
                ws2.skill_name AS user1WantedSkill,
                up2.profile_picture AS user2ProfilePicture  -- Include user2's profile picture
            FROM 
                user u1
            JOIN 
                user_profile up1 ON u1.id = up1.user_id
            JOIN 
                user_skills us ON u1.id = us.user_id
            JOIN 
                user u2 ON u1.id <> u2.id
            JOIN 
                user_profile up2 ON u2.id = up2.user_id
            JOIN 
                wanted_skills ws ON u2.id = ws.user_id
            JOIN 
                user_skills us2 ON u2.id = us2.user_id AND us.skill_name = ws.skill_name
            JOIN 
                wanted_skills ws2 ON u1.id = ws2.user_id AND us2.skill_name = ws2.skill_name
            WHERE 
                u1.id = :user1Id
            """;

        Query nativeQuery = entityManager.createNativeQuery(query)
                                          .setParameter("user1Id", user1Id);
        List<Object[]> results = nativeQuery.getResultList();

        return results.stream().map(record -> {
            UserSkillMatchDTO dto = new UserSkillMatchDTO();
            dto.setUser1Id(((Number) record[0]).longValue());
            dto.setUser1Username((String) record[1]);
            dto.setUser1Skill((String) record[2]);
            dto.setUser2Id(((Number) record[3]).longValue());
            dto.setUser2Username((String) record[4]);
            dto.setUser2WantedSkill((String) record[5]);
            dto.setUser2Skill((String) record[6]);
            dto.setUser1WantedSkill((String) record[7]);
            dto.setUser2ProfilePicture((String) record[8]);  // Set user2's profile picture
            return dto;
        }).collect(Collectors.toList());
    }
}

