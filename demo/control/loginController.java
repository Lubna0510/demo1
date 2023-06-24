package com.example.demo.control;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.logindto2;
import com.example.demo.dto.loginformdto;
import com.example.demo.dto.updateLogindto;
import com.example.demo.entity.Loginform;
import com.example.demo.entity.PracticeEntity;
import com.example.demo.repository.loginrepository;
import com.example.demo.service.loginservice;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class loginController {
	
	@Autowired
	loginservice lservice;
	
	@Autowired
	loginrepository lrepository;
	
	@PostMapping("/signup")
	public void savedata(HttpServletResponse httpServletResponse,@RequestBody loginformdto ldt)
	{
		this.lservice.savedata(ldt);
			
	}
	
	@GetMapping("/loginuser")
	public ResponseDto<logindto2> getdata(HttpServletResponse httpServletResponse,@RequestParam(value="username")String username,@RequestParam(value="password")String password )
	{
		ResponseDto<logindto2> rstDto=new ResponseDto<>();
		int statusCode;
		List<String>checkname=lrepository.getLData(username, password);
		if(!checkname.isEmpty())
		{
			
			 statusCode=HttpStatus.OK.value();
			 rstDto.setStatusCode(statusCode);
			 rstDto.setMessage("login Success");
		    
		}
		else
		{
			statusCode=HttpStatus.NOT_FOUND.value();
			rstDto.setStatusCode(statusCode);
			rstDto.setMessage("Enter correct values");
		}
		
		return rstDto;
	}
	
	@PostMapping("/updatepass")
	public void updatedata (HttpServletResponse httpServletResponse,@RequestBody updateLogindto udto)
	{
		this.lservice.updatepass(udto);
		
		
	}

}
