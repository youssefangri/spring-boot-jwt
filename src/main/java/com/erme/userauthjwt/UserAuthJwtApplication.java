package com.erme.userauthjwt;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.erme.userauthjwt.bean.Role;
import com.erme.userauthjwt.bean.User;
import com.erme.userauthjwt.service.UserService;

@SpringBootApplication
public class UserAuthJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAuthJwtApplication.class, args);
	}
	
	@Bean
	PasswordEncoder passwrodEncoder() {
		 return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args ->{
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
			
			userService.saveUser(new User(null, "Youssef Angri", "ysf", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Ahmed Angri", "ahmed", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Abdelhafid Angri", "batar", "2000", new ArrayList<>()));
			
			userService.addRoleToUser("ysf", "ROLE_ADMIN");
			userService.addRoleToUser("ysf", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("batar", "ROLE_USER");
			userService.addRoleToUser("ahmed", "ROLE_USER");
			userService.addRoleToUser("ahmed", "ROLE_MANAGER");
			
		};
	}
}
