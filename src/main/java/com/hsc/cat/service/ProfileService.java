package com.hsc.cat.service;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsc.cat.TO.CreateProfileTO;
import com.hsc.cat.VO.CreateProfileVO;
import com.hsc.cat.entity.ProfileEntity;
import com.hsc.cat.repository.ProfileRepository;
import com.hsc.cat.repository.SkillProfileRepository;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
private SkillProfileService skillProfileService;
	
	@Autowired
	private SkillProfileRepository skillProfileRepository;
	
	@PersistenceContext
	EntityManager entityManager;
	
	public CreateProfileTO createProfile(CreateProfileVO profileVO) {
		
		ProfileEntity exists=profileRepository.findByEmpId(profileVO.getUserName());
		
		
		
		CreateProfileTO createProfileTO=new CreateProfileTO();
		
		if(exists==null) {
		ProfileEntity profileEntity=new ProfileEntity();
		profileEntity.setEmpId(profileVO.getUserName());
		profileEntity.setProjectRole(profileVO.getProjectRole());
		Date date=new Date();
		profileEntity.setCreationDate(date);
		profileRepository.save(profileEntity);
		
		ProfileEntity saved=profileRepository.findByEmpId(profileVO.getUserName());
		
		createProfileTO.setFirstName(profileVO.getFirstName());
		createProfileTO.setLastName(profileVO.getLastName());
		createProfileTO.setDepartment(profileVO.getDepartment());
		createProfileTO.setEmailId(profileVO.getEmailId());
		createProfileTO.setProjectRole(profileEntity.getProjectRole());
		createProfileTO.setUserName(profileVO.getUserName());
		createProfileTO.setSelectedSkills(profileVO.getSelectedSkills());
		
		System.out.println("\n\n\n#######################"+saved.getId());
		
		for(String skill:profileVO.getSelectedSkills()) {
			skillProfileService.saveSkillProfile(skill, saved.getId());
		}
		
		}
		
		
		else {
		//We need to update the profile
			
			profileRepository.updateProfile(profileVO.getUserName(), profileVO.getProjectRole());
			ProfileEntity saved=profileRepository.findByEmpId(profileVO.getUserName());
			System.out.println("\n\n\n#######################"+saved.getId());
			createProfileTO.setFirstName(profileVO.getFirstName());
			createProfileTO.setLastName(profileVO.getLastName());
			createProfileTO.setDepartment(profileVO.getDepartment());
			createProfileTO.setEmailId(profileVO.getEmailId());
			createProfileTO.setProjectRole(saved.getProjectRole());
			createProfileTO.setUserName(profileVO.getUserName());
			createProfileTO.setSelectedSkills(profileVO.getSelectedSkills());
			if(profileVO.getSelectedSkills()!=null && !profileVO.getSelectedSkills().isEmpty())
			{
				//delete previous skills
				//skillProfileRepository.deleteByProfileId(saved.getId());
				String query="Delete from SkillProfileEntity e WHERE e.profileId=:profileId";
				Query q=entityManager.createQuery(query);
				q.setParameter("profileId",saved.getId());
			}
			for(String skill:profileVO.getSelectedSkills()) {
				skillProfileService.saveSkillProfile(skill, saved.getId());
			}
			
		}
		return createProfileTO;
	}
}
