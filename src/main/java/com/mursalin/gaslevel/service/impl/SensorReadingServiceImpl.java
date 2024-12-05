//package com.mursalin.gaslevel.service.impl;
//
//import com.mursalin.gaslevel.model.SensorReading;
//import com.mursalin.gaslevel.repository.SensorReadingRepository;
//import com.mursalin.gaslevel.service.SensorReadingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class SensorReadingServiceImpl implements SensorReadingService {
//
//    private final SensorReadingRepository sensorReadingRepository;
//
//    @Autowired
//    public SensorReadingServiceImpl(SensorReadingRepository sensorReadingRepository) {
//        this.sensorReadingRepository = sensorReadingRepository;
//    }
//
//    @Override
//    public SensorReading saveSensorReading(SensorReading sensorReading) {
//        return sensorReadingRepository.save(sensorReading);
//    }
//
//    @Override
//    public List<SensorReading> getAllSensorReadings() {
//        return sensorReadingRepository.findAll();
//    }
//
//    @Override
//    public SensorReading getLatestSensorReading() {
//        return sensorReadingRepository.findFirstByOrderByTimestampDesc();
//    }
//}
