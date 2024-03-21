package com.moon.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 描述信息：申请人信息
 *
 * @author moon
 * @version 1.0
 * @date 2024/3/20 15:32
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("申请人信息")
public class ApplicantMessage implements Serializable {

    private static final long serialVersionUID = 8473293468203956318L;

    @ApiModelProperty("编号")
    private Long locationId;

    @ApiModelProperty(value = "申请公司")
    private String applicant;

    @ApiModelProperty("卡车类型")
    private String facilityType;

    @ApiModelProperty("cnn")
    private Long cnn;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("地址详情")
    private String locationDescription;

    @ApiModelProperty("permit")
    private String permit;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("地址详情")
    private String foodItems;

    @ApiModelProperty("x")
    private String x;

    @ApiModelProperty("y")
    private String y;

    @ApiModelProperty("计划表")
    private String schedule;

    @ApiModelProperty("blockLot实体类")
    private LocationMessage location;

    @ApiModelProperty("blockLot实体类")
    private BlockLotMessage blockLot;

    @ApiModelProperty("申请时间实体类")
    private ApplicantDateMessage applicantDateMessage;

    @ApiModelProperty("行政区域")
    private AdministrativeRegion administrativeRegion;

    @ApiModelProperty("经纬实体类")
    private LocationMessage locationMessage;


}
