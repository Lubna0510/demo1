package com.example.demo.service;


import com.example.demo.dto.NewEntityDt;
import com.example.demo.entity.NewEntity;

public interface Newservice {
	
	NewEntity saveData(NewEntityDt newEntityDt);
	
	
	NewEntity save(NewEntity newEntity);
	
	NewEntity update(NewEntityDt newEntityDt);
	void delete(Long id);
	
}
