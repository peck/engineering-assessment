package com.dtx.it.foodtruck.component;

import com.dtx.it.foodtruck.entity.FoodFacility;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andy Wang
 * @Created 2024/3/24 12:03
 */
@Component
public class CsvFileParser {

    public List<FoodFacility> readCsvData(String filePath) {
        try (java.io.FileReader fileReader = new java.io.FileReader(filePath)) {
            return new CsvToBeanBuilder<FoodFacility>(fileReader)
                    .withType(FoodFacility.class)
                    .withIgnoreEmptyLine(true)
                    .build().parse();
        } catch (IOException e) {
            System.err.println("IOException while read Csv Data ." + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exception while read Csv Data." + e.getMessage());
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        URL filePath = CsvFileParser.class.getClassLoader().getResource("data/Mobile_Food_Facility_Permit.csv");
        //1.load created_by/modified_by combined csv
        CsvFileParser instance1 = new CsvFileParser();
        String allTableFileName = "Mobile_Food_Facility_Permit";
        List<FoodFacility> csvDataList = instance1.readCsvData(filePath.getPath());

        System.out.println("======================================================");
        System.out.println("print out original non-included item count:" + csvDataList.size());
        System.out.println("======================================================");
    }
}
