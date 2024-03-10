package com.in.pradip.binding;

import java.io.Serializable;

import lombok.Data;

@Data
public class Country implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer sno;
	private String name;
	private String countrCode;
}
