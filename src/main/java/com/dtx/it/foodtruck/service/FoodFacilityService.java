package com.dtx.it.foodtruck.service;

import com.dtx.it.foodtruck.exception.FetchException;
import com.dtx.it.foodtruck.component.CsvFileParser;
import com.dtx.it.foodtruck.entity.FoodFacility;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Component
public class FoodFacilityService {

    @Autowired
    private CsvFileParser csvFileParser;

    //TODO Optional Null check
    public final LoadingCache<String, List<FoodFacility>> foodFacilityLoadingCache = CacheBuilder.newBuilder()
            .initialCapacity(1_000_000)
            .expireAfterWrite(24, TimeUnit.HOURS)
            .build(
                    new CacheLoader<String, List<FoodFacility>>() {
                        @Override
                        public List<FoodFacility> load(String filePath)  {
                            return csvFileParser.readCsvData(filePath);
                        }
                    });

    public List<FoodFacility> getAll(){
        URL filePath = CsvFileParser.class.getClassLoader().getResource("data/Mobile_Food_Facility_Permit.csv");
        List<FoodFacility> foodFacilityList = null;
        try {
            foodFacilityList = foodFacilityLoadingCache.get(filePath.getPath());
        } catch (ExecutionException e) {
            throw new FetchException("Fetch Food Facility Data Failed. "+e.getMessage());
        }
        return foodFacilityList;
    }

    public List<FoodFacility> getByApplicant(String applicantName){

        return null;
    }
    


}
