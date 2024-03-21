package com.moon.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述信息：申请时间实体类
 *
 * @author moon
 * @version 1.0
 * @date 2024/3/20 16:44
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("申请时间实体类")
public class ApplicantDateMessage implements Serializable {

    private static final long serialVersionUID = 8473293468203956321L;


    @ApiModelProperty("日期时间")
    private String daysHours;

    @ApiModelProperty("NOISent")
    private String nOISent;

    @ApiModelProperty("received")
    private String received;

    @ApiModelProperty("approved")
    private Date approved;

    @ApiModelProperty("priorPermit")
    private Date priorPermit;

    @ApiModelProperty("expirationDate")
    private Integer expirationDate;


}
