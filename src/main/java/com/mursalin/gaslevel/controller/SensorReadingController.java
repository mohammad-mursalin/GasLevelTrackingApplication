package com.mursalin.gaslevel.controller;

//import com.mursalin.gaslevel.model.SensorReading;
//import com.mursalin.gaslevel.service.SensorReadingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sensor-readings")
public class SensorReadingController {

//    private final SensorReadingService sensorReadingService;
//
//    @Autowired
//    public SensorReadingController(SensorReadingService sensorReadingService) {
//        this.sensorReadingService = sensorReadingService;
//    }
//
//    @PostMapping
//    public ResponseEntity<String> saveSensorReading(@RequestBody SensorReading sensorReading) {
//        sensorReading.setTimestamp(LocalDateTime.now());
//        sensorReadingService.saveSensorReading(sensorReading);
//        return ResponseEntity.ok("Sensor reading saved successfully.");
//    }
//
//    @GetMapping
//    public ResponseEntity<List<SensorReading>> getAllSensorReadings() {
//        return ResponseEntity.ok(sensorReadingService.getAllSensorReadings());
//    }
//
//    @GetMapping("/latest")
//    public ResponseEntity<SensorReading> getLatestSensorReading() {
//        SensorReading latestReading = sensorReadingService.getLatestSensorReading();
//        if (latestReading != null) {
//            return ResponseEntity.ok(latestReading);
//        } else {
//            return ResponseEntity.noContent().build();
//        }
//    }

    @GetMapping("/data")
    public ResponseEntity<String> checkBackendStatus() {
        return ResponseEntity.ok("Backend is up and running!");
    }

    @PostMapping("/data")
    public ResponseEntity<String> receiveSensorData(@RequestParam int sensorValue) {
        System.out.println("Received sensor data: " + sensorValue);
        // Process the data as needed (e.g., store in database)
        return ResponseEntity.ok("Data received successfully");
    }
}
