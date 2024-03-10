package com.in.pradip.binding;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaToJsonConverter {

	public static void main(String[] args) throws Exception {


		Address addr = new Address();
		addr.setCity("Pune");
		addr.setState("Maharashtraha");
		addr.setCountry("India");
		
		
		Customer c = new Customer();
		c.setId(1);
		c.setName("pradip");
		c.setEmail("pradip123@gmail.com");
		c.setPhno(8026728913L);
		c.setAdd(addr);
	  
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("Customer.json"), c);
		System.out.println("Json File created...!");
		
	}

}
