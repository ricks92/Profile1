package com.hsc.cat.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hsc.cat.TO.CreateProfileTO;
import com.hsc.cat.VO.CreateProfileVO;
import com.hsc.cat.service.EmployeeSkillService;
import com.hsc.cat.service.ProfileService;
import com.hsc.cat.utilities.JSONOutputEnum;
import com.hsc.cat.utilities.JSONOutputModel;

@RestController
public class ProfileController {

	private static final Logger LOGGER = (Logger) LogManager.getLogger(EmployeeSkillService.class);
	@Autowired
	private ProfileService profileService;
	
	@RequestMapping(value="cat/createProfile",method=RequestMethod.POST)
	@CrossOrigin
	@ResponseBody
	public JSONOutputModel createProfile(@RequestBody CreateProfileVO profileVO) {
		JSONOutputModel output= new JSONOutputModel();
		LOGGER.info("Request came to create profile for:"+profileVO.getUserName());
	
//		if(profileVO.getUsername()==null) {
//			output.setMessage("Username cannot be null");
//			output.setStatus(JSONOutputEnum.FAILURE.getValue());
//			return output;
//		}
		CreateProfileTO createProfileTO= profileService.createProfile(profileVO);
		output.setData(createProfileTO);
		if(createProfileTO!=null) {
			output.setMessage("Profile created successfully");
			output.setStatus(JSONOutputEnum.SUCCESS.getValue());
		}
		else {
			output.setMessage("Profile could not be  created");
			output.setStatus(JSONOutputEnum.FAILURE.getValue());
		}
		
		
		return output;
	}
}
