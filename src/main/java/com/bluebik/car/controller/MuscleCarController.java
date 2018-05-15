package com.bluebik.car.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluebik.car.exception.MuscleCarException;
import com.bluebik.car.model.MuscleCar;
import com.bluebik.car.model.Response;
import com.bluebik.car.service.MuscleCarService;

@RestController
@RequestMapping(value = "/api/cars")
public class MuscleCarController {

	private static final Logger logger = LoggerFactory.getLogger(MuscleCarController.class);

	@Autowired
	private MuscleCarService muscleCarService;

	@RequestMapping(value = "/get-car/{id}", method = RequestMethod.GET)
	public ResponseEntity<MuscleCar> getMuscleCar(@PathVariable("id") long id) throws MuscleCarException {
		logger.info("MuscleCar id to return " + id);

		MuscleCar muscleCar = muscleCarService.getMuscleCar(id);
		if (muscleCar == null || muscleCar.getId() <= 0) {
			throw new MuscleCarException("MuscleCar doesn't exist");
		}

		return new ResponseEntity<MuscleCar>(muscleCarService.getMuscleCar(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/delete-car/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> deleteMuscleCar(@PathVariable("id") long id) throws MuscleCarException {
		logger.info("MuscleCar id to delete " + id);

		MuscleCar muscleCar = muscleCarService.getMuscleCar(id);
		if (muscleCar == null || muscleCar.getId() <= 0) {
			throw new MuscleCarException("MuscleCar delete doesn't exist");
		}
		muscleCarService.deleteMuscleCar(muscleCar.getId());

		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "MuscleCar has been deleted"),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/add-car", method = RequestMethod.POST)
	public ResponseEntity<MuscleCar> saveMuscleCar(@RequestBody MuscleCar muscleCar) throws MuscleCarException {
		logger.info("MuscleCar to save " + muscleCar);

		return new ResponseEntity<MuscleCar>(muscleCarService.saveMuscleCar(muscleCar), HttpStatus.OK);
	}

	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	public ResponseEntity<List<MuscleCar>> listAllMuscleCar() {
		logger.info("Returning all the MuscleCar's");

		return new ResponseEntity<List<MuscleCar>>(muscleCarService.listAllCars(), HttpStatus.OK);
	}

	@RequestMapping(value = "/update-car/{id}", method = RequestMethod.PUT)
	public ResponseEntity<MuscleCar> updateMuscleCar(@PathVariable("id") long id, @RequestBody MuscleCar muscleCar)
			throws MuscleCarException {
		logger.info("MuscleCar to update id " + id);

		MuscleCar muscleCarOld = muscleCarService.getMuscleCar(id);
		if (muscleCarOld == null || muscleCarOld.getId() <= 0) {
			throw new MuscleCarException("MuscleCar to update doesn't exist");
		}
		muscleCar.setId(muscleCarOld.getId());
		return new ResponseEntity<MuscleCar>(muscleCarService.saveMuscleCar(muscleCar), HttpStatus.OK);
	}

}
