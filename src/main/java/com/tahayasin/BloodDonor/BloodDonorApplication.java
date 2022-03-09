package com.tahayasin.BloodDonor;

import com.tahayasin.BloodDonor.domain.Address;
import com.tahayasin.BloodDonor.domain.AppRole;
import com.tahayasin.BloodDonor.domain.AppUser;
import com.tahayasin.BloodDonor.domain.Person;
import com.tahayasin.BloodDonor.service.AppUserService;
import com.tahayasin.BloodDonor.service.BloodDonorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;

@SpringBootApplication
public class BloodDonorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodDonorApplication.class, args);
	}


	@Bean
	CommandLineRunner run(AppUserService appUserService, BloodDonorService bloodDonorService) {
		return args -> {
			appUserService.saveRole(new AppRole(null, "ROLE_ADMIN"));
			//appUserService.saveRole(new AppRole(null, "ROLE_SUPER_ADMIN"));
			appUserService.saveRole(new AppRole(null, "ROLE_USER"));
			//appUserService.saveRole(new AppRole(null, "ROLE_MANAGER"));
			appUserService.saveRole(new AppRole(null, "ROLE_DONOR"));

			appUserService.saveUser(new AppUser(null, new Person("John", "Travolta", "Male", Date.valueOf("1998-06-18")), "john", "1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Will", "Smith", "Male", Date.valueOf("1996-04-20")), "will", "1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Jim", "Carry", "Male", Date.valueOf("1998-03-08")),"jim", "1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"arnold", "1234", new HashSet<>()));

//			appUserService.saveUser(new AppUser(null, new Person("John", "Travolta", "Male", Date.valueOf("1998-06-18")), "john", "1234", new ArrayList<>()));
//			appUserService.saveUser(new AppUser(null, new Person("Will", "Smith", "Male", Date.valueOf("1996-04-20")), "will", "1234", new ArrayList<>()));
//			appUserService.saveUser(new AppUser(null, new Person("Jim", "Carry", "Male", Date.valueOf("1998-03-08")),"jim", "1234", new ArrayList<>()));
//			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"arnold", "1234", new ArrayList<>()));

			bloodDonorService.saveDonor("john", "B+", new Address("Chandni chowk", "Baner", "Pune", "Maharashtra", "123456"), "987654321", Date.valueOf("2022-01-18"));
			bloodDonorService.saveDonor("will", "B+", new Address("Hinjewadi chowk", "Hinjewadi phase 1", "Pune", "Maharashtra", "654321"), "987654321", Date.valueOf("2022-02-27"));
			bloodDonorService.saveDonor("arnold", "B+", new Address("New Market", "Kankarbagh", "patna", "Bihar", "123456"), "987654321", Date.valueOf("2021-12-31"));

			appUserService.addRoleToUser("john", "ROLE_USER");
			appUserService.addRoleToUser("john", "ROLE_DONOR");
			appUserService.addRoleToUser("will", "ROLE_USER");
			appUserService.addRoleToUser("will", "ROLE_DONOR");
			appUserService.addRoleToUser("jim", "ROLE_USER");
			appUserService.addRoleToUser("arnold", "ROLE_DONOR");
			appUserService.addRoleToUser("arnold", "ROLE_ADMIN");
			appUserService.addRoleToUser("arnold", "ROLE_USER");

		};
	}

}
