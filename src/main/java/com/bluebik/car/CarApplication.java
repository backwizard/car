package com.bluebik.car;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bluebik.car.model.MuscleCar;
import com.bluebik.car.repository.MuscleCarRepository;

@SpringBootApplication
public class CarApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner setup(MuscleCarRepository muscleCarRepository) {
		return (args) -> {
			MuscleCar muscleCar = new MuscleCar();
			muscleCar.setCarBrand("carBrand");
			muscleCar.setCarModel("carModel");
			muscleCar.setHorsepower("horsepower");
			muscleCar.setCarEngine("carEngine");
			muscleCarRepository.save(muscleCar);
		};
	}
}
