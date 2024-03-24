package com.ffp.demo.database.dataobject;

import lombok.Data;

@Data
public class ApplicantDO {
  private Long id;
  private String applicantName;
  private String facilityType;
  private String foodItems;
  private String schedule;
  private String daysHours;
  private String address;
}
