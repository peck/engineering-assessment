package com.dtx.it.foodtruck.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Andy Wang
 * @Created 2024/3/24 10:47
 */

@Data
@NoArgsConstructor
public class GeoLocationInfo {

    private String latitude;

    private String longitude;

    private String x;

    private String y;
}
