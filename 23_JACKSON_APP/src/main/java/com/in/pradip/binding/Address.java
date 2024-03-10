package com.in.pradip.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
	private String city;
	private String country;
	private String state;

}
