package com.mursalin.gaslevel.controller;

import com.mursalin.gaslevel.model.SensorReading;
import com.mursalin.gaslevel.service.SensorReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/sensor-readings")
public class SensorReadingController {

    private final SensorReadingService sensorReadingService;

    @Autowired
    public SensorReadingController(SensorReadingService sensorReadingService) {
        this.sensorReadingService = sensorReadingService;
    }

    @PostMapping
    public ResponseEntity<String> saveSensorReading(@RequestBody SensorReading sensorReading) {
        sensorReading.setTimestamp(LocalDateTime.now());
        sensorReadingService.saveSensorReading(sensorReading);
        return ResponseEntity.ok("Sensor reading saved successfully.");
    }

    @GetMapping
    public ResponseEntity<List<SensorReading>> getAllSensorReadings() {
        return ResponseEntity.ok(sensorReadingService.getAllSensorReadings());
    }

    @GetMapping("/latest")
    public ResponseEntity<SensorReading> getLatestSensorReading() {
        SensorReading latestReading = sensorReadingService.getLatestSensorReading();
        if (latestReading != null) {
            return ResponseEntity.ok(latestReading);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
