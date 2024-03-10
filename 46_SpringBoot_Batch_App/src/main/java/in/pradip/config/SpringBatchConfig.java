package in.pradip.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import in.pradip.entity.Customer;
import in.pradip.repo.CustomerRepository;
import lombok.AllArgsConstructor;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class SpringBatchConfig {

	private JobBuilderFactory jobBuilderFactory;
	private StepBuilderFactory stepBuilderFactory;
	private CustomerRepository customerRepository;

	//item reader bean 
	
	@Bean
	public FlatFileItemReader<Customer> customerReader() {
		FlatFileItemReader<Customer> itemReader = new FlatFileItemReader<>();
		itemReader.setResource(new FileSystemResource("src/main/resources/customers.csv"));
		itemReader.setName("csv-reader");
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(lineMapper());
		return itemReader;
	}
	 // it will map the cvs file data with customer object
	private LineMapper<Customer> lineMapper() {

		DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<>();

		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(","); //it means coma sepreated data bcz it csv file
		lineTokenizer.setStrict(false); //it means if any value missing consider space or null
		lineTokenizer.setNames("id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob");
		// To set above data to the customer object
		BeanWrapperFieldSetMapper<Customer> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Customer.class); // specifying in which class we want to store the data

		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);

		return lineMapper;
	}
	//item processor
	@Bean
	public CustomerProcessor customerProcessor() {
		return new CustomerProcessor();
	}

	// Item writer 
	
	@Bean
	public RepositoryItemWriter<Customer> customerWriter() {

		RepositoryItemWriter<Customer> writer = new RepositoryItemWriter<>();
		writer.setRepository(customerRepository); // our jpa repository
		writer.setMethodName("save");  // using this we can store or save data in database

		return writer;
	}
	
	// step bean
	
	@Bean
	public Step step() {
		return stepBuilderFactory.get("step-1").<Customer, Customer>chunk(10) // chunk 10 means 10 records process at a time
						  .reader(customerReader())
						  .processor(customerProcessor())
						  .writer(customerWriter())
						  .taskExecutor(taskExecutor())
						  .build();
	}
	
	// job bean
	
	@Bean
	public Job job() {
		return jobBuilderFactory.get("customers-import")
								.flow(step())            // we have multiple step then we can write like this flow(step1()).flow(step2())
								.end()
								.build();
	}
	
	@Bean
	public TaskExecutor taskExecutor() {
		SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
		taskExecutor.setConcurrencyLimit(10);
		return taskExecutor;
	}
	
	
}







