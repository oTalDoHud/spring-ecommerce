package com.example.aula01.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.aula01.model.entities.Order;
import com.example.aula01.model.entities.User;
import com.example.aula01.repositories.OrderRepository;
import com.example.aula01.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private OrderRepository OrderRepo;

	@Override
	public void run(String... args) throws Exception {
		User hud = new User("Hudson", "Hudson@gmail.com", "11 932165604", "1234");

		User pp = new User("Peterson", "Peterson@gmail.com", "11 916572354", "abcde");

		userRepo.saveAll(Arrays.asList(hud, pp));
		
		Order o1 = new Order(Instant.parse("2019-06-20T19:53:07Z"), hud); 
		Order o2 = new Order(Instant.parse("2019-07-21T03:42:10Z"), pp); 
		Order o3 = new Order(Instant.parse("2019-07-22T15:21:22Z"), hud); 
		
		OrderRepo.saveAll(Arrays.asList(o1, o2, o3));
		
//		hud.getOrders().add(01);
//		hud.getOrders().add(03);
	}

}
