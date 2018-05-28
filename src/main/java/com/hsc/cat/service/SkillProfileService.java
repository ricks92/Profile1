package com.hsc.cat.service;

import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsc.cat.entity.Skill;
import com.hsc.cat.entity.SkillProfileEntity;
import com.hsc.cat.repository.SkillProfileRepository;
import com.hsc.cat.repository.SkillRepository;

@Service
public class SkillProfileService {

	
	private static final Logger LOGGER = (Logger) LogManager.getLogger(EmployeeSkillService.class);
	@Autowired
	private SkillProfileRepository skillProfileRepository;
	@Autowired
	private SkillRepository skillRepository;
	public void saveSkillProfile(String name,int profileId) {
		Skill skill=skillRepository.findBySkillName(name);
		LOGGER.debug("Saving skill:"+name +" in profile:"+profileId);
		if(skillProfileRepository.findByProfileIdAndSkillId(profileId,skill.getSkillId())!=null) {
			
			LOGGER.debug("Record already exixts for  skill:"+name +" in profile:"+profileId);
			return;
		}
		
		
		SkillProfileEntity skillProfileEntity= new SkillProfileEntity();
		skillProfileEntity.setProfileId(profileId);
		
		skillProfileEntity.setSkillId(skill.getSkillId());
		Date d=new Date();
		skillProfileEntity.setCreationDate(d);
		skillProfileRepository.save(skillProfileEntity);
		
	}
}
