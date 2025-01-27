package com.mursalin.gaslevel.service.impl;

import com.mursalin.gaslevel.exception.CustomException;
import com.mursalin.gaslevel.model.SensorReading;
import com.mursalin.gaslevel.repository.SensorReadingRepository;
import com.mursalin.gaslevel.service.SensorReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class SensorReadingServiceImpl implements SensorReadingService {

    private final SensorReadingRepository sensorReadingRepository;
    private double sensorValue = 0;
    private String location = null;

    @Autowired
    public SensorReadingServiceImpl(SensorReadingRepository sensorReadingRepository) {
        this.sensorReadingRepository = sensorReadingRepository;
    }

    @Override
    public void receivedSensorData(Map<String, Object> payload) {

        sensorValue = (double) payload.get("sensorValue");

        sensorReadingRepository.save(new SensorReading(location, sensorValue, LocalDateTime.now()));

        System.out.println("Received Gas Concentration: " + sensorValue + " ppm");

    }

    @Override
    public SensorReading saveSensorReading(SensorReading sensorReading) {

        sensorReading.setTimestamp(LocalDateTime.now());
        sensorReading.setGasLevel(sensorValue);
        System.out.println(sensorReading.getLocation());
        updateLocation(sensorReading.getLocation());
        return sensorReadingRepository.save(sensorReading);
    }

    @Override
    public List<SensorReading> getAllSensorReadings() {
        return sensorReadingRepository.findAll();
    }

    @Override
    public double getLatestSensorReading() {

        if(sensorValue < 0 ) {
            throw new CustomException("sensor is not sending correct value");
        }
        return sensorValue;
    }



    private void updateLocation(String location) {
        this.location = location;
    }
}
