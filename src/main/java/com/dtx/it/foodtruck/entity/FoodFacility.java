package com.dtx.it.foodtruck.entity;

import com.dtx.it.foodtruck.entity.converter.FacilityTypeConverter;
import com.opencsv.bean.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

/**
 * @author Andy Wang
 * @Created 2024/3/24 10:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodFacility implements Serializable {

    @CsvBindByName(column = "locationId")
    private Long locationId;

    @NonNull
    @CsvBindByName(column = "Applicant")
    private String applicant;

    @CsvCustomBindByName(column = "FacilityType",converter = FacilityTypeConverter.class)
    private FacilityType facilityType;

    public enum FacilityType {
        TRUCK("Truck"),

        PUSHCART("Push Cart"),

        UNKNOWN("Unknown");

        final String value;


        FacilityType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static FacilityType getByValue(String value){
            for(FacilityType type : FacilityType.values()){
                if(type.getValue().contains(value)){
                    return type;
                }
            }
            return UNKNOWN;
        }
    }

    @CsvBindByName(column = "cnn")
    private String cnn;

    @CsvBindByName(column = "LocationDescription")
    private String locationDescription;

    @CsvBindByName(column = "Address")
    private String address;

    private BlocklotInfo blocklotInfo;

    @CsvBindByName(column = "permit")
    private String permitLicense;

    private PermitStatus permitStatus;

    enum PermitStatus {
        REQUESTED,
        APPROVED,
        EXPIRED,
        ISSUED,
        SUSPEND;
    }

    /**
     * the provided food items
     */
    @CsvBindByName(column = "FoodItems")
    private String foodItems;

//    @CsvBindAndJoinByName(mapType = GeoLocationInfo.class)
    private GeoLocationInfo geoLocationInfo;

    private String permitScheduleLink;

    private String permitDaysHours;

    private String nioSent;

    private String permitApprovedDate;

    private String permitReceivedDate;

    private String permitExpirationDate;


    private DistractsInfo distractsInfo;


    private String zipCodes;

    private String neighborhoods;
}
