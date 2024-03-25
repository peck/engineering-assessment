package com.dtx.it.foodtruck.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andy Wang
 * @Created 2024/3/24 19:56
 */
public class FoodFacilityGroup {

    private List<FoodFacility> foodFacilityList;


    public List<FoodFacility> getFoodFacilityList() {
        if(this.foodFacilityList==null || this.foodFacilityList.isEmpty())
            this.foodFacilityList = new ArrayList<>();
        return this.foodFacilityList;
    }
}
