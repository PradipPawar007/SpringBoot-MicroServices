package com.in.pradip.exception;


public class UserNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8449507815248824587L;

	public UserNotFoundException () {
	}
	
	public UserNotFoundException (String msg) {
		super(msg);
	}
	
}
