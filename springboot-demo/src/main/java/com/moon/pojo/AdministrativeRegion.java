package com.moon.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 描述信息：行政区域
 *
 * @author moon
 * @version 1.0
 * @date 2024/3/20 16:55
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("行政区域")
public class AdministrativeRegion implements Serializable {

    private static final long serialVersionUID = 8473293468203956322L;


    @ApiModelProperty(value = "防火区")
    private Integer firePreventionDistricts;

    @ApiModelProperty("警区")
    private Integer policeDistricts;

    @ApiModelProperty("主管区")
    private Integer supervisorDistricts;

    @ApiModelProperty("邮政编码")
    private Integer zipCodes;

    @ApiModelProperty("社区")
    private Integer neighborhoods;


}
