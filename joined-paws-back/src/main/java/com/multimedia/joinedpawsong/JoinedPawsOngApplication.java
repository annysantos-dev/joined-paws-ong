package com.multimedia.joinedpawsong;

import com.multimedia.joinedpawsong.core.models.Pet;
import com.multimedia.joinedpawsong.core.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JoinedPawsOngApplication implements CommandLineRunner {

	@Autowired
	private PetRepository petRepository;

	public static void main(String[] args) {
		SpringApplication.run(JoinedPawsOngApplication.class, args);
	}

	public void run(String... args) throws Exception{
		var pet = new Pet().builder()
			.name("Xuxa")
			.story("Cachorra moradora de rua")
			.photo("http://animais.culturamix.com/blog/wp-content/gallery/cachorro-morador-de-rua1/cachorro-morador-de-rua-1.jpg")
			.build();
		petRepository.save(pet);

	}
}
