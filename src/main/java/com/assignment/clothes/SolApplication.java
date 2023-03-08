package com.assignment.clothes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.assignment.clothes.model.Clothe;
import com.assignment.clothes.repository.ClotheRepository;

@SpringBootApplication
public class SolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataRunner(ClotheRepository clotheRepository) {
		return args -> clotheRepository.save(
				Clothe.builder().name("Havayanas Polo").price(19.10).brand("Dior").yearOfCreation(2021).build());
	}
}
