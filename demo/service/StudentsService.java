package com.example.demo.service;

import com.example.demo.dto.StudentDto;
import com.example.demo.dto.student_courseDto;
import com.example.demo.entity.Students;

public interface StudentsService {
	void saveCourses(student_courseDto ScDto);
	void updateCourses(student_courseDto ScDto);
	void deleteCourses(Long id);
	void signUp(StudentDto SDto);

}
