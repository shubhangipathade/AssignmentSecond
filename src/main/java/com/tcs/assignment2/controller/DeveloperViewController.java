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

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Scope (value = "session")
@Component (value = "developerView")
@ELBeanName(value = "developerView")
@Join(path = "/view_developer/{id}", to = "/developers/developerView.jsf")
public class DeveloperViewController {


	@Autowired
	DeveloperService developerService;
	@Autowired
	SkillService skillService;

	private DeveloperDTO developerDTO = new DeveloperDTO();
	private List<SkillDTO> skillDTO;

	@Deferred
	@RequestAction
	@IgnorePostback
	public void getOneDeveloper() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String id = request.getParameter("id");
		developerDTO = developerService.getSingleDeveloper(Long.parseLong(id));
	}

	public DeveloperDTO getDeveloper(){
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


	public String updateDeveloperSkills() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String id = request.getParameter("id");
		DeveloperDTO currentDeveloperData = developerService.getSingleDeveloper(Long.parseLong(id));
		String skillUpdate = currentDeveloperData.getSkills() + " , " + developerDTO.getSkills();
		developerDTO.setSkills(skillUpdate);
		boolean developerUpdated = developerService.updateDeveloper(developerDTO, Long.parseLong(id));
		if(developerUpdated == true) {
			return "/developers/developerList.xhtml?faces-redirect=true";
		}
		return null;
	}




}
