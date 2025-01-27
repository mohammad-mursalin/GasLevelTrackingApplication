package com.mursalin.gaslevel.controller;

import com.mursalin.gaslevel.model.SensorReading;
import com.mursalin.gaslevel.service.SensorReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sensor-readings")
@CrossOrigin(value = "http://localhost:5173")
public class SensorReadingController {

    private final SensorReadingService sensorReadingService;

    @Autowired
    public SensorReadingController(SensorReadingService sensorReadingService) {
        this.sensorReadingService = sensorReadingService;
    }

    @GetMapping
    public ResponseEntity<List<SensorReading>> getAllSensorReadings() {
        return ResponseEntity.ok(sensorReadingService.getAllSensorReadings());
    }

    @GetMapping("/data")
    public ResponseEntity<String> checkBackendStatus() {
        return ResponseEntity.ok("Backend is up and running!");
    }


    @PostMapping("/data")
    public ResponseEntity<?> receiveSensorDataNew(@RequestBody Map<String, Object> payload) {

        sensorReadingService.receivedSensorData(payload);

        return ResponseEntity.ok("Data received");
    }

    @PostMapping("/latest")
    public ResponseEntity<Double> getLatestSensorReading(@RequestBody SensorReading sensorReading) {

        sensorReadingService.saveSensorReading(sensorReading);

        double latestReading = sensorReadingService.getLatestSensorReading();

        if (latestReading != 0) {
            return ResponseEntity.ok(latestReading);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
