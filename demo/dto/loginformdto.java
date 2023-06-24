package com.example.demo.dto;

import com.example.demo.entity.Loginform;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class loginformdto {
	private Long id;
	private String firstname;
	private String lastname;
	private String email_id;
	private String user_name;
	private String password;

}
