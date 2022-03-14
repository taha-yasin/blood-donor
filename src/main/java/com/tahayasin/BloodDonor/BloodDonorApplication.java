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

			appUserService.saveUser(new AppUser(null, new Person("John", "Travolta", "Male", Date.valueOf("1998-06-18")), "john@test.com", "Abcd@1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Will", "Smith", "Male", Date.valueOf("1996-04-20")), "will@test.com", "Abcd@1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Jim", "Carry", "Male", Date.valueOf("1998-03-08")),"jim@test.com", "Abcd@1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"arnold@test.com", "Abcd@1234", new HashSet<>()));

			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"1@test.com", "Abcd@1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"2@test.com", "Abcd@1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"3@test.com", "Abcd@1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"4@test.com", "Abcd@1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"5@test.com", "Abcd@1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"6@test.com", "Abcd@1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"7@test.com", "Abcd@1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"8@test.com", "Abcd@1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"9@test.com", "Abcd@1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"10@test.com", "Abcd@1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"11@test.com", "Abcd@1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"12@test.com", "Abcd@1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"13@test.com", "Abcd@1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"14@test.com", "Abcd@1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"15@test.com", "Abcd@1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"16@test.com", "Abcd@1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"17@test.com", "Abcd@1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"18@test.com", "Abcd@1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"19@test.com", "Abcd@1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"20@test.com", "Abcd@1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"21@test.com", "Abcd@1234", new HashSet<>()));
			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"22@test.com", "Abcd@1234", new HashSet<>()));

//			appUserService.saveUser(new AppUser(null, new Person("John", "Travolta", "Male", Date.valueOf("1998-06-18")), "john", "1234", new ArrayList<>()));
//			appUserService.saveUser(new AppUser(null, new Person("Will", "Smith", "Male", Date.valueOf("1996-04-20")), "will", "1234", new ArrayList<>()));
//			appUserService.saveUser(new AppUser(null, new Person("Jim", "Carry", "Male", Date.valueOf("1998-03-08")),"jim", "1234", new ArrayList<>()));
//			appUserService.saveUser(new AppUser(null, new Person("Arnold", "Schwarzenegger", "Male", Date.valueOf("1997-11-14")),"arnold", "1234", new ArrayList<>()));

			bloodDonorService.saveDonor("john@test.com", "B+", new Address("Chandni chowk, Baner", "Pune", "Maharashtra", "123456"), "987654321", Date.valueOf("2022-01-18"));
			bloodDonorService.saveDonor("will@test.com", "B+", new Address("Hinjewadi chowk, Hinjewadi phase 1", "Pune", "Maharashtra", "654321"), "987654321", Date.valueOf("2022-02-27"));
			bloodDonorService.saveDonor("arnold@test.com", "B+", new Address("New Market, Kankarbagh", "patna", "Bihar", "123456"), "987654321", Date.valueOf("2021-12-31"));

			bloodDonorService.saveDonor("1@test.com", "B+", new Address("Chandni chowk, Baner", "Pune", "Maharashtra", "123456"), "987654321", Date.valueOf("2022-01-18"));
			bloodDonorService.saveDonor("2@test.com", "B+", new Address("Hinjewadi chowk, Hinjewadi phase 1", "Pune", "Maharashtra", "654321"), "987654321", Date.valueOf("2022-02-27"));
			bloodDonorService.saveDonor("3@test.com", "B+", new Address("New Market, Kankarbagh", "patna", "Bihar", "123456"), "987654321", Date.valueOf("2021-12-31"));
			bloodDonorService.saveDonor("4@test.com", "B+", new Address("Chandni chowk, Baner", "Pune", "Maharashtra", "123456"), "987654321", Date.valueOf("2022-01-18"));
			bloodDonorService.saveDonor("5@test.com", "B+", new Address("Hinjewadi chowk, Hinjewadi phase 1", "Pune", "Maharashtra", "654321"), "987654321", Date.valueOf("2022-02-27"));
			bloodDonorService.saveDonor("6@test.com", "B+", new Address("New Market, Kankarbagh", "patna", "Bihar", "123456"), "987654321", Date.valueOf("2021-12-31"));
			bloodDonorService.saveDonor("7@test.com", "B+", new Address("Chandni chowk, Baner", "Pune", "Maharashtra", "123456"), "987654321", Date.valueOf("2022-01-18"));
			bloodDonorService.saveDonor("8@test.com", "B+", new Address("Hinjewadi chowk, Hinjewadi phase 1", "Pune", "Maharashtra", "654321"), "987654321", Date.valueOf("2022-02-27"));
			bloodDonorService.saveDonor("9@test.com", "B+", new Address("New Market, Kankarbagh", "patna", "Bihar", "123456"), "987654321", Date.valueOf("2021-12-31"));
			bloodDonorService.saveDonor("10@test.com", "B+", new Address("Chandni chowk, Baner", "Pune", "Maharashtra", "123456"), "987654321", Date.valueOf("2022-01-18"));
			bloodDonorService.saveDonor("11@test.com", "B+", new Address("Hinjewadi chowk, Hinjewadi phase 1", "Pune", "Maharashtra", "654321"), "987654321", Date.valueOf("2022-02-27"));
			bloodDonorService.saveDonor("12@test.com", "B+", new Address("New Market, Kankarbagh", "patna", "Bihar", "123456"), "987654321", Date.valueOf("2021-12-31"));
			bloodDonorService.saveDonor("13@test.com", "B+", new Address("Chandni chowk, Baner", "Pune", "Maharashtra", "123456"), "987654321", Date.valueOf("2022-01-18"));
			bloodDonorService.saveDonor("14@test.com", "B+", new Address("Hinjewadi chowk, Hinjewadi phase 1", "Pune", "Maharashtra", "654321"), "987654321", Date.valueOf("2022-02-27"));
			bloodDonorService.saveDonor("15@test.com", "B+", new Address("New Market, Kankarbagh", "patna", "Bihar", "123456"), "987654321", Date.valueOf("2021-12-31"));
			bloodDonorService.saveDonor("16@test.com", "B+", new Address("Chandni chowk, Baner", "Pune", "Maharashtra", "123456"), "987654321", Date.valueOf("2022-01-18"));
			bloodDonorService.saveDonor("17@test.com", "B+", new Address("Hinjewadi chowk, Hinjewadi phase 1", "Pune", "Maharashtra", "654321"), "987654321", Date.valueOf("2022-02-27"));
			bloodDonorService.saveDonor("18@test.com", "B+", new Address("New Market, Kankarbagh", "patna", "Bihar", "123456"), "987654321", Date.valueOf("2021-12-31"));
			bloodDonorService.saveDonor("19@test.com", "B+", new Address("Chandni chowk, Baner", "Pune", "Maharashtra", "123456"), "987654321", Date.valueOf("2022-01-18"));
			bloodDonorService.saveDonor("20@test.com", "B+", new Address("Hinjewadi chowk, Hinjewadi phase 1", "Pune", "Maharashtra", "654321"), "987654321", Date.valueOf("2022-02-27"));
			bloodDonorService.saveDonor("21@test.com", "B+", new Address("New Market, Kankarbagh", "patna", "Bihar", "123456"), "987654321", Date.valueOf("2021-12-31"));

			appUserService.addRoleToUser("john@test.com", "ROLE_USER");
			appUserService.addRoleToUser("john@test.com", "ROLE_DONOR");
			appUserService.addRoleToUser("will@test.com", "ROLE_USER");
			appUserService.addRoleToUser("will@test.com", "ROLE_DONOR");
			appUserService.addRoleToUser("jim@test.com", "ROLE_USER");
			appUserService.addRoleToUser("arnold@test.com", "ROLE_DONOR");
			appUserService.addRoleToUser("arnold@test.com", "ROLE_ADMIN");
			appUserService.addRoleToUser("arnold@test.com", "ROLE_USER");

			appUserService.addRoleToUser("1@test.com", "ROLE_USER");
			appUserService.addRoleToUser("2@test.com", "ROLE_DONOR");
			appUserService.addRoleToUser("3@test.com", "ROLE_USER");
			appUserService.addRoleToUser("4@test.com", "ROLE_DONOR");
			appUserService.addRoleToUser("5@test.com", "ROLE_USER");
			appUserService.addRoleToUser("6@test.com", "ROLE_DONOR");
			appUserService.addRoleToUser("7@test.com", "ROLE_ADMIN");
			appUserService.addRoleToUser("8@test.com", "ROLE_USER");
			appUserService.addRoleToUser("9@test.com", "ROLE_DONOR");
			appUserService.addRoleToUser("10@test.com", "ROLE_USER");
			appUserService.addRoleToUser("11@test.com", "ROLE_DONOR");
			appUserService.addRoleToUser("12@test.com", "ROLE_USER");
			appUserService.addRoleToUser("13@test.com", "ROLE_DONOR");
			appUserService.addRoleToUser("14@test.com", "ROLE_ADMIN");
			appUserService.addRoleToUser("15@test.com", "ROLE_USER");
			appUserService.addRoleToUser("16@test.com", "ROLE_DONOR");
			appUserService.addRoleToUser("17@test.com", "ROLE_USER");
			appUserService.addRoleToUser("18@test.com", "ROLE_DONOR");
			appUserService.addRoleToUser("19@test.com", "ROLE_USER");
			appUserService.addRoleToUser("20@test.com", "ROLE_DONOR");
			appUserService.addRoleToUser("21@test.com", "ROLE_ADMIN");

			appUserService.addRoleToUser("1@test.com", "ROLE_USER");
			appUserService.addRoleToUser("2@test.com", "ROLE_DONOR");
			appUserService.addRoleToUser("3@test.com", "ROLE_USER");
			appUserService.addRoleToUser("4@test.com", "ROLE_DONOR");
			appUserService.addRoleToUser("5@test.com", "ROLE_USER");
			appUserService.addRoleToUser("6@test.com", "ROLE_DONOR");
			appUserService.addRoleToUser("7@test.com", "ROLE_ADMIN");
			appUserService.addRoleToUser("8@test.com", "ROLE_USER");
			appUserService.addRoleToUser("9@test.com", "ROLE_DONOR");
			appUserService.addRoleToUser("10@test.com", "ROLE_USER");
			appUserService.addRoleToUser("11@test.com", "ROLE_DONOR");
			appUserService.addRoleToUser("12@test.com", "ROLE_USER");
			appUserService.addRoleToUser("13@test.com", "ROLE_DONOR");
			appUserService.addRoleToUser("14@test.com", "ROLE_ADMIN");
			appUserService.addRoleToUser("15@test.com", "ROLE_USER");
			appUserService.addRoleToUser("16@test.com", "ROLE_DONOR");
			appUserService.addRoleToUser("17@test.com", "ROLE_USER");
			appUserService.addRoleToUser("18@test.com", "ROLE_DONOR");
			appUserService.addRoleToUser("19@test.com", "ROLE_USER");
			appUserService.addRoleToUser("20@test.com", "ROLE_DONOR");
			appUserService.addRoleToUser("21@test.com", "ROLE_ADMIN");

		};
	}

}
