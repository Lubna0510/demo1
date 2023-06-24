package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.json.JSONParserConstants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Loginform;
import com.example.demo.entity.PracticeEntity;

public interface loginrepository extends JpaRepository<Loginform, Long>{
@Query(value="select * from login where user_name=? and password=?",nativeQuery =true)
List<String> getLData(String user_name , String password);

@Query(value="select * from login  where email_id=?",nativeQuery=true)
List<Loginform> findByEmail_id(String email_id);



}
