package com.dtx.it.foodtruck.controller;

import com.dtx.it.foodtruck.entity.FoodFacility;
import com.dtx.it.foodtruck.service.FoodFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/foodFacility/v1")
public class FoodFacilityController {

    private FoodFacilityService foodFacilityService;

    @Autowired
    public FoodFacilityController(FoodFacilityService foodFacilityService) {
        this.foodFacilityService = foodFacilityService;
    }

    // Endpoint to retrieve all shops
    @GetMapping("/getAll")
    public ResponseEntity<List<FoodFacility>> getAll() {
        List<FoodFacility> foodFacilityList = foodFacilityService.getAll();
        return new ResponseEntity<>(foodFacilityList, HttpStatus.OK);
    }

    // Endpoint to retrieve list by its applicant
    @GetMapping("/{applicant}")
    public ResponseEntity<List<FoodFacility>> getShopByLocationId(@PathVariable String applicant) {
        List<FoodFacility> foodFacilityList = foodFacilityService.getByApplicant(applicant);
        if (foodFacilityList != null) {
            return new ResponseEntity<>(foodFacilityList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
