package com.musala.dronesservice.core.jobs;

import com.musala.dronesservice.core.domain.droneregister.DroneModel;
import com.musala.dronesservice.core.persistence.DronePersistence;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.DecimalFormat;
import java.util.List;

@SpringBootApplication
@EnableScheduling
@EnableAsync
@RequiredArgsConstructor
public class CheckDroneBattery {

    static final Logger log = LoggerFactory.getLogger(CheckDroneBattery.class);

    private final DronePersistence dronePersistence;

    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTaskAsync() throws InterruptedException {

        List<DroneModel> arrDroneBatteryLeves = dronePersistence.getDrones();

        DecimalFormat decFormat = new DecimalFormat("#%");

        arrDroneBatteryLeves.forEach(droneModel -> log.info("Serial:  " + droneModel.getSerialNumber()
                + "  Battery Level " + decFormat.format(droneModel.getBattery())));

        Thread.sleep(1000);
    }
}
