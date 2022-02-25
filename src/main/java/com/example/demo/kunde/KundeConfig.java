package com.example.demo.kunde;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KundeConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(KundeRepository repository) {
		return args -> {

			
			
			Kunde kunde00 = new Kunde("Alex", "Alman", "AlexAlman@mail.com", 20); 
			Kunde kunde01 = new Kunde("Berta", "Boss", "BertaBoss@mail.com", 30); 
			Kunde kunde02 = new Kunde("Carl", "Clapper", "CarlClapper@mail.com", 40);
			
//			ArrayList <Kunde> listeKunden = new ArrayList<Kunde>();
//			listeKunden.add(kunde00);
//			listeKunden.add(kunde01);
//			listeKunden.add(kunde02);			
//			repository.saveAll(listeKunden);
			
			repository.saveAll(List.of(kunde00, kunde01, kunde02));
		};
	}

}
