package me.wonwoo;

import me.wonwoo.customer.domain.Customer;
import me.wonwoo.customer.repository.CustomerRepository;
import me.wonwoo.user.domain.User;
import me.wonwoo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CustomerRepository customerRepository;

//	@Bean
//	public CommandLineRunner commandLineRunner(){
//		return args ->{
//			Arrays.asList(new User("wonwoo"),new User("kevin"))
//			.forEach(userRepository::save);
//			Arrays.asList(new Customer("customerName"), new Customer("test"))
//				.forEach(customerRepository::save);
//		};
//	}
}
