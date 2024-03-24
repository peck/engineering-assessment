package com.ffp.demo.domain.applicant;



import com.alibaba.cola.domain.Entity;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class Location implements Serializable {
    private Long id;
    private String x;
    private String y ;
    private String latitude ;
    private String longitude;
    private String blocklot;
    private String block;
    private String lot ;
    private String address;
    private String location;
    private String locationDesc;
    private String zipCode;
    private String firePreventionDistricts;
    private String policeDistricts;
    private String supervisorDistricts;
    private String neighborhoodsOld ;
}
