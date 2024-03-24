package com.ffp.demo.dto.data;

import lombok.Data;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class ApplicantDTO {
    private String address;
    private String applicantName;
    private String facilityType;
    private String daysHours;
    private List<String> foods;
}
