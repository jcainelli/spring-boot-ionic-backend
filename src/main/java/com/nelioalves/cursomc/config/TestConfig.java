/*CONFIGURAÇÕES ESPECIFICAS PROFILLER TESTE */
package com.nelioalves.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nelioalves.cursomc.services.DBService;

@Configuration
@Profile("test") // linke no application.properties
public class TestConfig {

	@Autowired
	private DBService dbService;

	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateDatabase();
		return true;
	}

}