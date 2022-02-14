package com.tahayasin.BloodDonor;

import com.tahayasin.BloodDonor.domain.AppRole;
import com.tahayasin.BloodDonor.domain.AppUser;
import com.tahayasin.BloodDonor.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class BloodDonorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodDonorApplication.class, args);
	}


	@Bean
	CommandLineRunner run(AppUserService appUserService) {
		return args -> {
			appUserService.saveRole(new AppRole(null, "John", "ROLE_ADMIN"));
			appUserService.saveRole(new AppRole(null, "Will", "ROLE_SUPER_ADMIN"));
			appUserService.saveRole(new AppRole(null, "Jim", "ROLE_USER"));
			appUserService.saveRole(new AppRole(null, "Arnold", "ROLE_MANAGER"));

			appUserService.saveUser(new AppUser(null, "John", "Travolta", "john", "1234", new ArrayList<>()));
			appUserService.saveUser(new AppUser(null, "Will", "Smith", "will", "1234", new ArrayList<>()));
			appUserService.saveUser(new AppUser(null, "Jim", "Carry", "jim", "1234", new ArrayList<>()));
			appUserService.saveUser(new AppUser(null, "Arnold", "Schwarzenegger", "arnold", "1234", new ArrayList<>()));

			appUserService.addRoleToUser("john", "ROLE_USER");
			appUserService.addRoleToUser("will", "ROLE_MANAGER");
			appUserService.addRoleToUser("jim", "ROLE_ADMIN");
			appUserService.addRoleToUser("arnold", "ROLE_SUPER_ADMIN");
			appUserService.addRoleToUser("arnold", "ROLE_ADMIN");
			appUserService.addRoleToUser("arnold", "ROLE_USER");

		};
	}

}
