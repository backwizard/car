package com.bluebik.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bluebik.car.model.MuscleCar;

@Repository("muscleCarRepository")
public interface MuscleCarRepository extends JpaRepository<MuscleCar, Long> {

}
