package com.tcs.assignment2.service;


import com.tcs.assignment2.entity.SkillEntityTable;
import com.tcs.assignment2.dto.SkillDTO;
import com.tcs.assignment2.repository.SkillsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillService {
	@Autowired
	SkillsRepo skillsRepo;

	public List<SkillDTO> getAllSkills() {
		List<SkillDTO> allSkills = new ArrayList<SkillDTO>();
		List<SkillEntityTable> skillsEntity = skillsRepo.findAll();
		for(SkillEntityTable singleSkill: skillsEntity ) {
			SkillDTO skill =  mapEntityToModel(singleSkill);
			allSkills.add(skill);
		}
		return allSkills;
	}

	private SkillDTO mapEntityToModel(SkillEntityTable skillEntityTable){
		SkillDTO skillDTO = new SkillDTO();
		skillDTO.setId(skillEntityTable.getId());
		skillDTO.setSkill(skillEntityTable.getSkill());
		return skillDTO;
	}
}
