package com.example.demo.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.NewEntityDt;
import com.example.demo.entity.NewEntity;
import com.example.demo.repository.NewRepository;
import com.example.demo.service.Newservice;
@Service
public class NewserviceImpl implements Newservice{
	@Autowired
NewRepository nrepository;

	
	@Override
	public NewEntity saveData(NewEntityDt newEntityDt) {
		NewEntity newEntity= new NewEntity(0l,newEntityDt.getCol1(),newEntityDt.getCol2());
	   newEntity  = nrepository.save(newEntity);
		return newEntity;
	}



	@Override
	public NewEntity save(NewEntity newEntity) {
		// TODO Auto-generated method stub
		 nrepository.save(newEntity);
		 return newEntity;
	}



	@Override
	public NewEntity update(NewEntityDt newEntityDt) {
		
		NewEntity newEntity= new NewEntity(newEntityDt.getId(),newEntityDt.getCol1(),newEntityDt.getCol2());
		   newEntity  = nrepository.save(newEntity);
			return newEntity;
	}



	@Override
	public void delete(Long id) {
		 Optional<NewEntity> newdata=nrepository.findById(id);
		
		nrepository.delete(newdata.get());
		
	}


	

}
 