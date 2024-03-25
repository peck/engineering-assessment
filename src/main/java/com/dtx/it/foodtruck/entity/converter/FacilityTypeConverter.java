package com.dtx.it.foodtruck.entity.converter;

import com.dtx.it.foodtruck.entity.FoodFacility;
import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

/**
 * @author Andy Wang
 * @Created 2024/3/24 16:49
 */
public class FacilityTypeConverter extends AbstractBeanField<FoodFacility.FacilityType,String> {
    @Override
    protected FoodFacility.FacilityType convert(String value) throws CsvDataTypeMismatchException {
        try {
            return FoodFacility.FacilityType.getByValue(value);
        } catch (IllegalArgumentException e) {
            throw new CsvDataTypeMismatchException("Invalid value for enum: " + value);
        }
    }
}
