package com.example.pkcontrol.controllers;

import com.example.pkcontrol.dtos.ParkingSpotDto;
import com.example.pkcontrol.services.ParkingSpotService;
import com.example.pkcontrol.models.ParkingSpotModel;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {
    final ParkingSpotService parkingSpotService;

    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto){
        var parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);  //acredito que faz a conversão de dto pra model
        parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
    }

}

//{
//        "parkingSpotNumber": "2058",
//        "licensePlateCar": "RRS8562",
//        "brandCar": "audi",
//        "modelCar": "q5",
//        "colorCar": "black",
//        "reponsibleName": "Carlos Daniel",
//        "apartment": "205",
//        "block": "B"
//        }