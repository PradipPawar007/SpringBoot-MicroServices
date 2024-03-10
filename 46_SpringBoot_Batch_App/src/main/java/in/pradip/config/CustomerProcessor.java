package in.pradip.config;

import org.springframework.batch.item.ItemProcessor;

import in.pradip.entity.Customer;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

	@Override
	public Customer process(Customer item) throws Exception {

		//logic to process data link below loginc
		
		/*
		 * if(item.getCountry().equals("India")) { 
		 *      return item; 
		 * }
		 */
		return item;
	}

}
