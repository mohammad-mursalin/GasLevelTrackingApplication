package com.mursalin.gaslevel.service;

import com.mursalin.gaslevel.model.SensorReading;

import java.util.List;
import java.util.Map;

public interface SensorReadingService {

    SensorReading saveSensorReading(SensorReading sensorReading);

    List<SensorReading> getAllSensorReadings();

    double getLatestSensorReading();

    void receivedSensorData(Map<String, Object> payload);
}
