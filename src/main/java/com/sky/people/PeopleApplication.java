package com.sky.people;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class PeopleApplication {

	public static void main(String[] args) {
//		SpringApplication.run(PeopleApplication.class, args);

		SpringApplication application =
				new SpringApplication(PeopleApplication.class);
		application.addListeners(new ApplicationPidFileWriter());
		application.run(args);

	}

}
