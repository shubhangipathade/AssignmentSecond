package com.tcs.assignment2.repository;

import com.tcs.assignment2.entity.DeveloperEntityTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepo extends JpaRepository<DeveloperEntityTable, Long> {

}
