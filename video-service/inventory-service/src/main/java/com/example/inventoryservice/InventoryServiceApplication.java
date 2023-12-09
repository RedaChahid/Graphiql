package com.example.inventoryservice;

import com.example.inventoryservice.entities.Creator;
import com.example.inventoryservice.entities.Video;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.inventoryservice.repositories.creatorRepository;
import com.example.inventoryservice.repositories.videoRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(creatorRepository creatorrepository, videoRepository videorepository){
		return args -> {
			Creator creator = Creator.builder().name("Reda").email("reda@gmail.com").build();
			creatorrepository.save(creator);
			Video video = Video.builder().name("video1").url("video1.com").build();
			videorepository.save(video);
		};
	}

}
