package com.mursalin.gaslevel.repository;

import com.mursalin.gaslevel.model.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorReadingRepository extends JpaRepository<SensorReading, Long> {

    SensorReading findFirstByOrderByTimestampDesc();
}
