package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Strudent_courseEntity;

public interface Student_courseRepository extends JpaRepository<Strudent_courseEntity, Long>{
	
	@Query(value="select * from student_course where selected_course=?",nativeQuery = true)
	List<String> getStudent(String student_course);
	
	Optional<Strudent_courseEntity> findById(Long id);

}
