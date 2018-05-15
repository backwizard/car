package com.bluebik.car.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bluebik.car.model.MuscleCar;
import com.bluebik.car.repository.MuscleCarRepository;

public class MuscleCarServiceTest {

	@Mock
	private MuscleCarRepository muscleCarRepository;

	@InjectMocks
	private MuscleCarServiceImpl muscleCarService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetMuscleCar(){
		MuscleCar muscleCar = new MuscleCar();
		muscleCar.setId(1);
		muscleCar.setCarBrand("carBrand");
		muscleCar.setCarModel("carModel");
		muscleCar.setHorsepower("horsepower");
		muscleCar.setCarEngine("carEngine");
		when(muscleCarRepository.findOne(1L)).thenReturn(muscleCar);
		
		MuscleCar result = muscleCarService.getMuscleCar(1);
		assertEquals(1, result.getId());
		assertEquals("carBrand", result.getCarBrand());
		assertEquals("carModel", result.getCarModel());
		assertEquals("horsepower", result.getHorsepower());
		assertEquals("carEngine", result.getCarEngine());
	}
	
	@Test
	public void deleteMuscleCar(){
		MuscleCar muscleCar = new MuscleCar();
		muscleCar.setId(1);
		muscleCar.setCarBrand("carBrand");
		muscleCar.setCarModel("carModel");
		muscleCar.setHorsepower("horsepower");
		muscleCar.setCarEngine("carEngine");
		when(muscleCarRepository.findOne(1L)).thenReturn(muscleCar);
		
		muscleCarService.deleteMuscleCar(1);
		verify(muscleCarRepository, times(1)).delete(muscleCar);
	}
	
	@Test
	public void saveMuscleCar(){
		MuscleCar muscleCar = new MuscleCar();
		muscleCar.setId(2);
		muscleCar.setCarBrand("carBrand");
		muscleCar.setCarModel("carModel");
		muscleCar.setHorsepower("horsepower");
		muscleCar.setCarEngine("carEngine");
		when(muscleCarRepository.save(muscleCar)).thenReturn(muscleCar);
		
		MuscleCar result = muscleCarService.saveMuscleCar(muscleCar);
		assertEquals(2, result.getId());
		assertEquals("carBrand", result.getCarBrand());
		assertEquals("carModel", result.getCarModel());
		assertEquals("horsepower", result.getHorsepower());
		assertEquals("carEngine", result.getCarEngine());
	}
	
	@Test
	public void testListAllCars(){
		List<MuscleCar> muscleCarList = new ArrayList<MuscleCar>();
		MuscleCar muscleCar = new MuscleCar();
		muscleCar.setId(1);
		muscleCar.setCarBrand("carBrand");
		muscleCar.setCarModel("carModel");
		muscleCar.setHorsepower("horsepower");
		muscleCar.setCarEngine("carEngine");
		muscleCarList.add(muscleCar);
		when(muscleCarRepository.findAll()).thenReturn(muscleCarList);
		
		List<MuscleCar> result = muscleCarService.listAllCars();
		assertEquals(1, result.size());
	}
	
}
