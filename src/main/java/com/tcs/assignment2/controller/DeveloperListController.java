package com.tcs.assignment2.controller;

import com.tcs.assignment2.dto.DeveloperDTO;
import com.tcs.assignment2.dto.SkillDTO;
import com.tcs.assignment2.service.DeveloperService;
import com.tcs.assignment2.service.SkillService;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Scope (value = "session")
@Join(path = "/", to = "/developers/developerList.jsf")
@Component (value = "developerList")
@ELBeanName(value = "developerList")
public class DeveloperListController {

	@Autowired
	private DeveloperService developerService;

	@Autowired
	private SkillService skillService;

	private List<DeveloperDTO> developerDTOS;

	@Deferred
	@RequestAction
	@IgnorePostback
	public void getDefaultDevelopersList() {
		developerDTOS = developerService.getAllDevelopers();
	}

	public List<DeveloperDTO> getAllDevelopersList() {
		return developerDTOS;
	}
	private DeveloperDTO developerDTO = new DeveloperDTO();
	private List<SkillDTO> skillDTO;

	//Add new
	public String addNewDeveloper() {
		boolean developerCreated = developerService.createNewDeveloper(developerDTO);
		if(developerCreated == true) {
			return "/developers/developerList.xhtml?faces-redirect=true";
		}
		return null;
	}

	public DeveloperDTO getDeveloperModel(){
		return developerDTO;
	}

	@Deferred
	@RequestAction
	@IgnorePostback
	public void getGeneralSkillsList() {
		skillDTO = skillService.getAllSkills();
	}


	public List<SkillDTO> getSkillsList() {
		return skillDTO;
	}



}
