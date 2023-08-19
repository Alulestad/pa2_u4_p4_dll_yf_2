package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repo.modelo.Propietario;
import com.example.demo.service.IPropietarioService;

@SpringBootApplication
public class Pa2U4P4DllYf2Application implements CommandLineRunner{
	
	@Autowired
	private IPropietarioService iPropietarioService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U4P4DllYf2Application.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	}

	
}
