package com.sda.travelagency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;

@SpringBootApplication
public class TravelagencyApplication implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

	public static void main(String[] args) {
		SpringApplication.run(TravelagencyApplication.class, args);
		
	}

	@Override
    public void customize(TomcatServletWebServerFactory factory) {
        factory.setPort(8081); // Change 8081 to the desired port
    }


}


