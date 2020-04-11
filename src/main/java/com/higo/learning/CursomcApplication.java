package com.higo.learning;

import com.higo.learning.services.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private S3Service S3;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) {
		S3.uploadFile("/home/higo/Documentos/Java springboot/documentos/6 - Amazon clound.pdf");

	}
}