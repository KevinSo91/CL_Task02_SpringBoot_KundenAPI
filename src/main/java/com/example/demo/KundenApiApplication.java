package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.kunde.Kunde;

@SpringBootApplication
@RestController
public class KundenApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KundenApiApplication.class, args);
	}

	
}
