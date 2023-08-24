package com.example.demo;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		User user1=userRepository.findById(0).orElse(null);
		if(user1==null) {
			User u1 = new User();
			//u1.setId(0);
			u1.setUsername("admin");
			u1.setRole("ADMIN");
			u1.setPassword("$2a$04$eOZeYGViXy11AE7zx6sITut0Vylilgibm6ew83CUP5LELvd30ZpFO");
			//u1.setPassword(this.bCryptPasswordEncoder.encode("hardik"));
			userRepository.save(u1);
		}

		User user2=userRepository.findById(2).orElse(null);
		if(user2==null) {
			User u2 = new User();
			//u2.setId(1);
			u2.setUsername("user");
			u2.setRole("USER");
			u2.setPassword("$2a$04$AT.rujXzoprLMok.sc1y1ez8So/VqRFn/1rv9pOwSoQGn/oOOnwue");
			//u2.setPassword(this.bCryptPasswordEncoder.encode("radhika"));
			userRepository.save(u2);
		}
	}
}
