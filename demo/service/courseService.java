package com.example.demo.service;

import com.example.demo.dto.courseEntityDto;
import com.example.demo.entity.courseEntity;

public interface courseService {
	void saveData(courseEntityDto Ced);
	void updateData(courseEntityDto Ced);
	void delete(Long id);
	courseEntity getData(courseEntity courseentity);
}
