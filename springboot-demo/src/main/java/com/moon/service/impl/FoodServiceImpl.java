package com.moon.service.impl;

import com.moon.pojo.*;
import com.moon.service.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 描述信息：食物 Service层
 *
 * @author moon
 * @version 1.0
 * @date 2024/3/20 17:46
 */
@Slf4j
@Service
public class FoodServiceImpl implements FoodService {

    /**
     * 根据 公司名 查询食物信息.
     *
     * @param applicantName
     * @return
     */
    @Override
    public List<ApplicantMessage> selectFoodByApplicantName(String applicantName) {

        List<ApplicantMessage> applicantMessageList = getApplicantMessage();

        List<ApplicantMessage> list = applicantMessageList.stream().filter(x -> x.getApplicant().equals(applicantName)).collect(Collectors.toList());
        return list;
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


        List<AdministrativeRegion> adminRegionList = getAdministrativeRegionList();
        List<ApplicantDateMessage> dateMessageList = getApplicantDateMessageList();
        List<BlockLotMessage> blockLotList = getBlockLotMessage();
        List<LocationMessage> locationList = getLocationMessage();

        msg1.setAdministrativeRegion(adminRegionList.get(0));
        msg2.setAdministrativeRegion(adminRegionList.get(1));
        msg3.setAdministrativeRegion(adminRegionList.get(2));
        msg4.setAdministrativeRegion(adminRegionList.get(3));

        msg1.setApplicantDateMessage(dateMessageList.get(1));
        msg2.setApplicantDateMessage(dateMessageList.get(1));
        msg3.setApplicantDateMessage(dateMessageList.get(0));
        msg4.setApplicantDateMessage(dateMessageList.get(0));

        msg1.setBlockLot(blockLotList.get(0));
        msg2.setBlockLot(blockLotList.get(1));
        msg3.setBlockLot(blockLotList.get(1));
        msg4.setBlockLot(blockLotList.get(0));

        msg1.setLocationMessage(locationList.get(0));
        msg2.setLocationMessage(locationList.get(0));
        msg3.setLocationMessage(locationList.get(1));
        msg4.setLocationMessage(locationList.get(1));


        applicantMsgList.add(msg1);
        applicantMsgList.add(msg2);
        applicantMsgList.add(msg3);
        applicantMsgList.add(msg4);

        return applicantMsgList;
    }



    /**
     * 获取 AdministrativeRegion 集合
     *
     * @param
     * @return
     * @author moon  2024/3/20 18:37
     */
    public List<AdministrativeRegion> getAdministrativeRegionList() {

        List<AdministrativeRegion> list = new ArrayList<AdministrativeRegion>();

        AdministrativeRegion admin1 = AdministrativeRegion.builder()
                                                    .firePreventionDistricts(5).policeDistricts(1).supervisorDistricts(10)
                                                    .zipCodes(308).neighborhoods(23)
                                                    .build();

        AdministrativeRegion admin2 = AdministrativeRegion.builder()
                                                    .firePreventionDistricts(1).policeDistricts(8).supervisorDistricts(4)
                                                    .zipCodes(64).neighborhoods(14)
                                                    .build();

        AdministrativeRegion admin3 = AdministrativeRegion.builder()
                                                    .firePreventionDistricts(4).policeDistricts(1).supervisorDistricts(10)
                                                    .zipCodes(28854).neighborhoods(6)
                                                    .build();

        AdministrativeRegion admin4 = AdministrativeRegion.builder()
                                                    .firePreventionDistricts(4).policeDistricts(1).supervisorDistricts(10)
                                                    .zipCodes(28860).neighborhoods(6)
                                                    .build();

        list.add(admin1);
        list.add(admin2);
        list.add(admin3);
        list.add(admin4);

        return list;
    }


    /**
     * 获取 ApplicantDateMessage 集合
     *
     * @param
     * @return
     * @author moon  2024/3/20 18:47
     */
    public List<ApplicantDateMessage> getApplicantDateMessageList() {

        List<ApplicantDateMessage> list = new ArrayList<>();

        ApplicantDateMessage dateMessage1 = ApplicantDateMessage.builder()
                                                        .daysHours("Mo-Fr:11AM-3PM").received("20170213").approved(new Date())
                                                        .priorPermit(new Date()).expirationDate(1)
                                                        .build();

        ApplicantDateMessage dateMessage2 = ApplicantDateMessage.builder()
                                                        .daysHours("").received("20210312").approved(new Date())
                                                        .priorPermit(new Date()).expirationDate(0)
                                                        .build();


        list.add(dateMessage1);
        list.add(dateMessage2);

        return list;
    }


    /**
     * 获取 BlockLotMessage
     *
     * @param
     * @return
     * @author moon  2024/3/20 18:53
     */
    public List<BlockLotMessage> getBlockLotMessage() {

        List<BlockLotMessage> list = new ArrayList<>();

        BlockLotMessage blockLotMsg1 = BlockLotMessage.builder().block("1202").lot("002D").build();
        BlockLotMessage blockLotMsg2 = BlockLotMessage.builder().block("289").lot("3").build();

        list.add(blockLotMsg1);
        list.add(blockLotMsg2);

        return list;
    }


    /**
     * 获取 LocationMessage
     *
     * @param
     * @return
     * @author moon  2024/3/20 18:53
     */
    public List<LocationMessage> getLocationMessage() {

        List<LocationMessage> list = new ArrayList<>();

        LocationMessage message1 = LocationMessage.builder().latitude("37.78546975").longitude("-122.4066158").build();
        LocationMessage message2 = LocationMessage.builder().latitude("36.98685611").longitude("-122.4068919").build();

        list.add(message1);
        list.add(message2);

        return list;
    }



}
