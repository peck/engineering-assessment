package com.dtx.it.foodtruck.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Andy Wang
 * @Created 2024/3/24 11:54
 */

@Data
@NoArgsConstructor
public class DistractsInfo {
    private String firePreventionDistricts;

    private String policeDistricts;

    private String supervisorDistracts;
}