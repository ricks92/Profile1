package com.hsc.cat.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hsc.cat.entity.ProfileEntity;
import com.hsc.cat.entity.SkillProfileEntity;
import com.hsc.cat.entity.UserDetails;
@Repository
public interface SkillProfileRepository extends JpaRepository<SkillProfileEntity, Integer>{

	
	SkillProfileEntity findByProfileIdAndSkillId(int profileId,int skillId);
	
	 @Modifying
	    @Transactional
	    void deleteByProfileId(int profileId);
	
}
