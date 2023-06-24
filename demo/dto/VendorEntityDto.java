package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorEntityDto {
	
	@NotEmpty(message="Please enter the value!")
	private String vendor_name;
	
	@NotEmpty(message="Please enter the value!")
	private Long invoice_no;
	
	@NotEmpty(message="Please enter the value!")
	private String 	reference;
	
	@NotEmpty(message="Please enter the value!")
	private Long grand_total;
	
	@NotEmpty(message="Please enter the value!")
	private Long discount;
	
	@NotEmpty(message="Please enter the value!")
	private Long net_amount;

}
