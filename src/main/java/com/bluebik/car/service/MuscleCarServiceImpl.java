package com.bluebik.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluebik.car.model.MuscleCar;
import com.bluebik.car.repository.MuscleCarRepository;

@Service("muscleCarService")
public class MuscleCarServiceImpl implements MuscleCarService {

	@Autowired
	private MuscleCarRepository muscleCarRepository;

	@Override
	public MuscleCar getMuscleCar(long id) {
		return muscleCarRepository.findOne(id);
	}

	@Override
	public void deleteMuscleCar(long id) {
		MuscleCar muscleCar = muscleCarRepository.findOne(id);
		System.out.println("muscleCar"+ muscleCar);
		muscleCarRepository.delete(muscleCar);
	}

	@Override
	public MuscleCar saveMuscleCar(MuscleCar muscleCar) {
		return muscleCarRepository.save(muscleCar);
	}

	@Override
	public List<MuscleCar> listAllCars() {
		return muscleCarRepository.findAll();
	}

}
