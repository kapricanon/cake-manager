package com.waracle;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.waracle.model.Cake;
import com.waracle.repository.CakeRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.waracle.repository")
@ComponentScan("com.waracle")
@EntityScan("com.waracle.model") 
public class CakeApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(CakeApplication.class, args);
	}
	
	
	//When the application starts we initialise the in-memory db with a few cakes
	@Bean
    public CommandLineRunner defaultCakes(CakeRepository repository) {
        repository.save(new Cake(
                "Chocolate Cake",
                "Chocolate cake with melted chocolate",
                "https://chocolate-imageURL.jpg"));
        repository.save(new Cake(
                "Lemon Cake",
                "Lemon drizzle cake",
                "https://lemon-imageURL.jpg"));
		
        repository.save(new Cake(
                "Blue Velvet Cake",
                "Blue Valvet Cake",
                "https://blue-valvet-imageURL.jpg"));
		
        return null;
	}
	
	
}
