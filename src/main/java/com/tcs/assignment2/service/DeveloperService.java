package com.tcs.assignment2.service;

import com.tcs.assignment2.entity.DeveloperEntityTable;
import com.tcs.assignment2.dto.DeveloperDTO;
import com.tcs.assignment2.repository.DeveloperRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeveloperService {

    @Autowired
	DeveloperRepo developerRepo;

    public List<DeveloperDTO> getAllDevelopers() {
        List<DeveloperDTO> allDevelopers = new ArrayList<DeveloperDTO>();
        List<DeveloperEntityTable> developersEntity = developerRepo.findAll();
        for(DeveloperEntityTable singleDeveloper: developersEntity ) {
            DeveloperDTO developer =  mapEntityToModel(singleDeveloper);
            allDevelopers.add(developer);
        }
        return allDevelopers;
    }


    public boolean createNewDeveloper(DeveloperDTO developersModel){
        DeveloperEntityTable entityToMap = new DeveloperEntityTable();
        DeveloperEntityTable developerEntityTable = developerRepo.save((mapModelToEntity(entityToMap, developersModel)));
        if(null != developerEntityTable.toString())
            return true;

        return false;
    }

	public DeveloperDTO getSingleDeveloper(Long id) {
		DeveloperEntityTable developersEntity = developerRepo.findOne(id);
		DeveloperDTO developer =  mapEntityToModel(developersEntity);
		return developer;
	}

   public boolean updateDeveloper(DeveloperDTO developersModel, Long id){
	   DeveloperEntityTable entityToMap = new DeveloperEntityTable();
        DeveloperEntityTable developerEntityTable = developerRepo.save((mapModelToEntity(entityToMap, developersModel)));
        if(null != developerEntityTable.toString())
            return true;
        return false;
    }


    private DeveloperDTO mapEntityToModel(DeveloperEntityTable developersEntity){
        DeveloperDTO developersModel = new DeveloperDTO();
        developersModel.setId(developersEntity.getId());
        developersModel.setFirstname(developersEntity.getFirstname());
        developersModel.setLastname(developersEntity.getLastname());
        developersModel.setEmail(developersEntity.getEmail());
        developersModel.setSkills(developersEntity.getSkills());
        return developersModel;
    }

   private DeveloperEntityTable mapModelToEntity(DeveloperEntityTable entityToMap, DeveloperDTO developersModel){
        DeveloperEntityTable developersEntity = new DeveloperEntityTable();
        developersEntity.setId(developersModel.getId());
        developersEntity.setFirstname(developersModel.getFirstname());
        developersEntity.setLastname(developersModel.getLastname());
        developersEntity.setEmail(developersModel.getEmail());
        developersEntity.setSkills(developersModel.getSkills());
        return developersEntity;
    }

}
