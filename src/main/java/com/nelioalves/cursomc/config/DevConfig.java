/*CONFIGURAÇÕES ESPECIFICAS PROFILLER TESTE */
package com.nelioalves.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nelioalves.cursomc.services.DBService;

@Configuration
@Profile("test") // linke no application.properties
public class DevConfig {

	@Autowired
	private DBService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		if (!"create".equals(strategy)) {
			dbService.instantiateDatabase();			
		}
		return true;
	}

}