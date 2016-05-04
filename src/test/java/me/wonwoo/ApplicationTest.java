package me.wonwoo;

import lombok.extern.slf4j.Slf4j;
import me.wonwoo.customer.repository.CustomerRepository;
import me.wonwoo.user.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ApplicationTest {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void userTest() {
		userRepository.findAll()
			.stream()
			.map(i -> i.toString())
			.forEach(log::info);
	}

	@Test
	public void custoemrTest(){
		customerRepository.findAll()
			.stream()
			.map(i -> i.toString())
			.forEach(log::info);
	}
}
