package com.assignment.clothes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.assignment.clothes.model.Clothe;
import com.assignment.clothes.repository.ClotheRepository;

@SpringBootApplication
public class ClothesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClothesApplication.class, args);

	}

	@Bean
	CommandLineRunner dataRunner(ClotheRepository clotheRepository) {
		return args -> {

			clotheRepository.save(Clothe
					.builder()
					.name("Polo Shirt")
					.price(13.99)
					.yearOfCreation("2023-03-21")
					.brand("Nike")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Jeans")
					.price(13.99)
					.yearOfCreation("2023-03-15")
					.brand("Dior")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Wedges")
					.price(13.99)
					.yearOfCreation("2023-03-03")
					.brand("Puma")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Jumpsuit")
					.price(13.99)
					.yearOfCreation("2023-03-03")
					.brand("Levis")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Polo Shirt")
					.price(13.99)
					.yearOfCreation("2023-03-03")
					.brand("Stone Islands")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Jeans")
					.price(13.99)
					.yearOfCreation("2023-03-03")
					.brand("Balenciaga")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Coat")
					.price(13.99)
					.yearOfCreation("2023-03-03")
					.brand("Nike")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Jacket")
					.price(13.99)
					.yearOfCreation("2023-03-03")
					.brand("Nike")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Sweat Pants")
					.price(13.99)
					.yearOfCreation("2023-03-03")
					.brand("Stone Island")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Romper")
					.price(13.99)
					.yearOfCreation("2023-03-03")
					.brand("Levis")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Blouse")
					.price(13.99)
					.yearOfCreation("2023-03-03")
					.brand("Nike")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Sweater")
					.price(13.99)
					.yearOfCreation("2023-03-03")
					.brand("Nike")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Polo Shirt")
					.price(13.99)
					.yearOfCreation("2023-03-03")
					.brand("Nike")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Jeans")
					.price(13.99)
					.yearOfCreation("2023-03-03")
					.brand("Dior")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Wedges")
					.price(13.99)
					.yearOfCreation("2023-03-03")
					.brand("Puma")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Jumpsuit")
					.price(13.99)
					.yearOfCreation("2023-03-21")
					.brand("Levis")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Polo Shirt")
					.price(13.99)
					.yearOfCreation("2023-03-14")
					.brand("Stone Islands")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Jeans")
					.price(13.99)
					.yearOfCreation("2023-03-19")
					.brand("Balenciaga")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Coat")
					.price(13.99)
					.yearOfCreation("2023-03-17")
					.brand("Nike")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Jacket")
					.price(13.99)
					.yearOfCreation("2023-03-03")
					.brand("Nike")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Sweat Pants")
					.price(13.99)
					.yearOfCreation("2023-03-05")
					.brand("Stone Island")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Romper")
					.price(13.99)
					.yearOfCreation("2023-03-01")
					.brand("Levis")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Blouse")
					.price(13.99)
					.yearOfCreation("2023-03-03")
					.brand("Nike")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Sweater")
					.price(13.99)
					.yearOfCreation("2023-03-03")
					.brand("Nike")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Polo Shirt")
					.price(13.99)
					.yearOfCreation("2023-03-03")
					.brand("Nike")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Jeans")
					.price(13.99)
					.yearOfCreation("2023-03-16")
					.brand("Dior")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Wedges")
					.price(13.99)
					.yearOfCreation("2023-03-18")
					.brand("Puma")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Jumpsuit")
					.price(13.99)
					.yearOfCreation("2023-03-18")
					.brand("Levis")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Polo Shirt")
					.price(13.99)
					.yearOfCreation("2023-03-25")
					.brand("Stone Islands")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Jeans")
					.price(13.99)
					.yearOfCreation("2023-03-19")
					.brand("Balenciaga")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Coat")
					.price(13.99)
					.yearOfCreation("2023-03-18")
					.brand("Nike")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Jacket")
					.price(13.99)
					.yearOfCreation("2023-03-05")
					.brand("Nike")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Sweat Pants")
					.price(13.99)
					.yearOfCreation("2023-03-07")
					.brand("Stone Island")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Romper")
					.price(13.99)
					.yearOfCreation("2023-03-08")
					.brand("Levis")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Blouse")
					.price(13.99)
					.yearOfCreation("2023-03-20")
					.brand("Nike")
					.build());
			clotheRepository.save(Clothe
					.builder()
					.name("Sweater")
					.price(13.99)
					.yearOfCreation("2023-03-21")
					.brand("Nike")
					.build());
		};
	}
}
