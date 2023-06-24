package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PracticeEntity;

@Repository
public interface PracticeRepository extends JpaRepository<PracticeEntity, Long>{
	
	@Query(value="Select * from user_info where first_name=?", nativeQuery=true)
	List<PracticeEntity> getAlldata(String firstName);
	
	Optional<PracticeEntity> findById(Long id);
	
	@Query(value="select first_name from user_info where first_name=?", nativeQuery = true)
	List<String> saveFirstName(String first_name );
	

}
