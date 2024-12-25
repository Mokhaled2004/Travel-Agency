package com.sda.NotificationSubsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;

@SpringBootApplication
public class NotificationSystemApplication implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

	public static void main(String[] args) {
		SpringApplication.run(NotificationSystemApplication.class, args);
	}

	@Override
	public void customize(TomcatServletWebServerFactory factory) {
		// Customize the Tomcat server here if needed
		factory.setPort(8080); // Set default server port
		factory.setContextPath("/notification"); // Set a custom context path
	}
}