package com.ex.onlineutils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;

@SpringBootApplication
public class OnlineUtilsApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(OnlineUtilsApplication.class, args);
		application.addListeners(new ApplicationPidFileWriter("./bin/app.pid"));
		application.run();
	}
}
