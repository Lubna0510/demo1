package com.example.demo.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProductlistDto {
	
	
	
	@NotEmpty(message="Please enter the value!")
	private List<ProductDto> referenceList;

}
