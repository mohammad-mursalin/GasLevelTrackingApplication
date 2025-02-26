package com.mursalin.gaslevel.allMethodTest;

import com.mursalin.gaslevel.controller.SensorReadingController;
import com.mursalin.gaslevel.model.SensorReading;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class TestMethods {

    @Autowired
    SensorReadingController controller;

    Map<String, Object> payload = new HashMap<>();

    public void setPayload() {
        payload.put("sensorValue", (Object) 33d);
    }

    @Test
    public void testStatus() {
        System.out.println(controller.checkBackendStatus());;
    }

    @Test
    public void testReceiveSensorData() {
        setPayload();
        controller.receiveSensorDataNew(payload);
    }

    @Test
    public void testGetLatest() {
        //controller.getLatestSensorReading(new SensorReading("room",2));
    }
    @Test
    public void testGetAll() {
        System.out.println(controller.getAllSensorReadings());;
    }
}
