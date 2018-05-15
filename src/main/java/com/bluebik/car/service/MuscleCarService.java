package com.bluebik.car.service;

import java.util.List;

import com.bluebik.car.model.MuscleCar;

public interface MuscleCarService {

	public MuscleCar getMuscleCar(long id);
	public void deleteMuscleCar(long id);
	public MuscleCar saveMuscleCar(MuscleCar muscleCar);
	public List<MuscleCar> listAllCars();

}
