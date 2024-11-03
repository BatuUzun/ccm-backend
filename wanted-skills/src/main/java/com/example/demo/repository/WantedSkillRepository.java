package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.WantedSkill;


@Repository
public interface WantedSkillRepository extends JpaRepository<WantedSkill, Long> {
    List<WantedSkill> findByUserId(Long userId);

}
