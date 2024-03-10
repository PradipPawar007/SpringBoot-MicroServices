package com.in.pradip.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	private Integer Id;
	private String name;
	private String email;
	private Long phno;
     
	private Address add;
	
}
