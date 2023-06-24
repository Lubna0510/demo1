package com.example.demo.service.Impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.dto.logindto2;
import com.example.demo.dto.loginformdto;
import com.example.demo.dto.updateLogindto;
import com.example.demo.entity.Loginform;
import com.example.demo.mailUtility.MailUtility;
import com.example.demo.repository.loginrepository;
import com.example.demo.service.loginservice;

@Service
@Transactional
public class loginserviceImpl implements loginservice {
	
	@Autowired
	loginrepository lrepository;
	
	@Autowired
	MailUtility mailUtils;
	
	@Value("${demo.url}")
	private String url;

	@Value("${demo.url1}")
	private String url1;
	

	@Override
	public void savedata(loginformdto ldt) {
		Loginform lform = new Loginform(0l,ldt.getFirstname(),ldt.getLastname(),ldt.getEmail_id(),ldt.getPassword(),ldt.getUser_name());
		lform = lrepository.save(lform);
		
		mailUtils.sendSimpleMessage(ldt.getEmail_id(),"password set link",url+ldt.getEmail_id()+url1);
		
	}

	@Override
	public Loginform getData(Loginform ldt) {
		lrepository.save(ldt);
		return ldt;
		
	}

	@Override
	public void updatepass(updateLogindto uld) {
	Loginform loginform = new Loginform();
lrepository.findByEmail_id(uld.getEmail_id());
	loginform.setPassword(uld.getPassword());
	lrepository.save(loginform);
		
		
	}

	

}
