package com.tcs.assignment2.repository;


import com.tcs.assignment2.entity.SkillEntityTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepo extends JpaRepository<SkillEntityTable, Long> {
}
