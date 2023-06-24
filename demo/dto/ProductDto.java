package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	

	private String product_name;
	
	
	private Long invoice_no;
	
	
	private Long quantity;
	
	
	private Long rate;
	
	
	private Long total;
	private String Product_pre;
	
	
	

}
