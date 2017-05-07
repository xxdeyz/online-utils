package com.ex.onlineutils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;

@SpringBootApplication
public class OnlineUtilsApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(OnlineUtilsApplication.class);
		application.addListeners(new ApplicationPidFileWriter("./onlineutils.pid"));
		application.run(args);
	}
}
