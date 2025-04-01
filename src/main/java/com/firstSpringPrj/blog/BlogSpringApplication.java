package com.firstSpringPrj.blog;

import com.firstSpringPrj.blog.models.Customer;
import com.firstSpringPrj.blog.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogSpringApplication implements CommandLineRunner {
	@Autowired
	private CustomerRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(BlogSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		repository.save(new Customer("Alex","Smith"));
		repository.save(new Customer("Sara", "Smith"));
		repository.save(new Customer("Jonh","Snow"));
		repository.save(new Customer("Alex","Michail"));

		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
	}


}
