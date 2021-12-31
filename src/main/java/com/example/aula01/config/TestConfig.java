package com.example.aula01.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.aula01.model.entities.User;
import com.example.aula01.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;

	@Override
	public void run(String... args) throws Exception {
		User hud = new User("Hudson", "Hudson@gmail.com", "11 932165604", "1234");

		User pp = new User("Peterson", "Peterson@gmail.com", "11 916572354", "abcde");

		userRepo.saveAll(Arrays.asList(hud, pp));




	}

}
