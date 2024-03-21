package com.moon.service.impl;

import com.moon.pojo.ApplicantMessage;
import com.moon.pojo.User;
import com.moon.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 描述信息：汽车Service层
 *
 * @author moon
 * @version 1.0
 * @date 2024/3/20 17:08
 */
@Slf4j
@Service
public class CarServiceImpl implements CarService {




    /**
     * 根据 编号 查询卡车信息.
     *
     * @param cnn
     * @return java.util.List<com.moon.pojo.ApplicantMessage>
     * @author moon  2024/3/20 17:31
     */
    @Override
    public List<ApplicantMessage> selectCarByCNN(Long cnn) {
        List<ApplicantMessage> applicantMsgList = getApplicantMessage();

        List<ApplicantMessage> targetList = applicantMsgList.stream().filter(x -> cnn.equals(x.getCnn())).collect(Collectors.toList());

        return targetList;
    }



    /**
     * 获取 ApplicationMessageList
     *
     * @param
     * @return
     * @author moon  2024/3/20 17:12
     */
    public List<ApplicantMessage> getApplicantMessage() {

        List<ApplicantMessage> applicantMsgList = new ArrayList<>();

        ApplicantMessage msg1 = ApplicantMessage.builder().locationId(1569152L).applicant("Datam SF LLC dba Anzu To You").facilityType("Truck").cnn(12463000L)
                                                .address("2535 TAYLOR ST")
                                                .locationDescription("TAYLOR ST: BAY ST to NORTH POINT ST (2500 - 2599)")
                                                .permit("21MFF-00106").status("APPROVED").foodItems("Asian Fusion - Japanese Sandwiches/Sliders/Misubi")
                                                .x("6008186.355").y("2121568.818").schedule("http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule&params=permit=21MFF-00106&ExportPDF=1&Filename=21MFF-00106_schedule.pdf")
                                                .build();

        ApplicantMessage msg2 = ApplicantMessage.builder().locationId(1569145L).applicant("Casita Vegana").facilityType("Truck").cnn(7553000L)
                                                .address("Assessors Block 7283/Lot004")
                                                .locationDescription("JOHN MUIR DR: LAKE MERCED BLVD to SKYLINE BLVD (200 - 699)")
                                                .permit("21MFF-00105").status("APPROVED").foodItems("Coffee: Vegan Pastries: Vegan Hot Dogs: Vegan Tamales: Te: Vegan Shakes")
                                                .x("5985417.15").y("2091453.145").schedule("http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule&params=permit=21MFF-00105&ExportPDF=1&Filename=21MFF-00105_schedule.pdf")
                                                .build();

        ApplicantMessage msg3 = ApplicantMessage.builder().locationId(1565593L).applicant("MOMO INNOVATION LLC").facilityType("Truck").cnn(3527000L)
                                                .address("2535 TAYLOR ST")
                                                .locationDescription("TAYLOR ST: BAY ST to NORTH POINT ST (2500 - 2599)")
                                                .permit("21MFF-00106").status("APPROVED").foodItems("Asian Fusion - Japanese Sandwiches/Sliders/Misubi")
                                                .x("6008186.355").y("2121568.818").schedule("http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule&params=permit=21MFF-00106&ExportPDF=1&Filename=21MFF-00106_schedule.pdf ")
                                                .build();

        ApplicantMessage msg4 = ApplicantMessage.builder().locationId(1548490L).applicant("MOMO INNOVATION LLC").facilityType("Truck").cnn(3527000L)
                                                .address("351 CALIFORNIA ST")
                                                .locationDescription("CALIFORNIA ST: BATTERY ST to SANSOME ST (300 - 399)")
                                                .permit("21MFF-00082").status("REQUESTED").foodItems("Noodles: Meat & Drinks")
                                                .x("6012479.849").y("2116741.356").schedule("http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule&params=permit=21MFF-00082&ExportPDF=1&Filename=21MFF-00082_schedule.pdf")
                                                .build();


        applicantMsgList.add(msg1);
        applicantMsgList.add(msg2);
        applicantMsgList.add(msg3);
        applicantMsgList.add(msg4);

        return applicantMsgList;
    }


}
