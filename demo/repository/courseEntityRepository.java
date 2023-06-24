package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.courseEntity;

@Repository
public interface courseEntityRepository extends JpaRepository<courseEntity, Long>  {
Optional<courseEntity> findById(Long Id);

@Query(value="select * from courses where course_name=?", nativeQuery = true)
List<courseEntity> getDetails(String course_name);
}
