package com.example.demo.control;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.NewEntityDt;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.DemoEntity;
import com.example.demo.entity.NewEntity;
import com.example.demo.repository.AsadRepository;
import com.example.demo.repository.NewRepository;
import com.example.demo.repository.exampleRepository;
import com.example.demo.service.Newservice;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class DemoController {

	@Autowired
	exampleRepository ExampleRepository;

	@Autowired
	AsadRepository aRepository;

	@Autowired
	NewRepository rRepository;
	@Autowired
	Newservice nservice;
	

	@GetMapping("/data")
	public List<DemoEntity> Demo1(HttpServletResponse httpServletResponse, @RequestParam(value="id")String id) {

		return ExampleRepository.findAll();

	}
	@GetMapping("/getemail")
	public List<String> getdata(HttpServletResponse httpServletResponse,@RequestParam(value="email_id")String email_id){
		return ExampleRepository.getAlldata(email_id);
	}
	
	

	@GetMapping("/dataid")
	public DemoEntity Demo3(HttpServletResponse httpServletResponse, @RequestParam(value = "id") Long id) {

		DemoEntity demo = ExampleRepository.findById(id).get();

		System.err.println("Demo" + demo);

		return demo;

	}

	@GetMapping("/test")
	public List<NewEntity> Demo4(@RequestParam(value = "col1") String col1) {

		List<NewEntity> lstEnt = rRepository.findByCol1(col1);

		return lstEnt;

	} 

	@PostMapping("/add")
	public NewEntity save(HttpServletResponse httpServletResponse,@RequestBody NewEntity Ne) {

		

		return this.nservice.save(Ne);

	} 
	@PostMapping("/save")
	public ResponseDto<NewEntity> savedata(HttpServletResponse httpServletResponse,@RequestBody NewEntityDt NeD ) {
		ResponseDto<NewEntity> rstDto=new ResponseDto<>();
		int statusCode;
	NewEntity newEntity= nservice.saveData(NeD);
	 statusCode=HttpStatus.OK.value();
	 rstDto.setStatusCode(statusCode);
	 rstDto.setMessage("Created Success");
	 rstDto.setData(newEntity);
		return rstDto;
		
	}
	@PostMapping("/update")
	public NewEntity updatedata(HttpServletResponse httpServletResponse,@RequestBody NewEntityDt NeD ) {
		return this.nservice.update(NeD);
		
		
	}
	@DeleteMapping("/deletedata")
	public  void  deletedata(HttpServletResponse httpServletResponse,@RequestParam(value="id") Long id )
	{
		nservice.delete(id);
	}
	
	
	
}
