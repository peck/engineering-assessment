package com.moon.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 描述信息：经度、维度
 *
 * @author moon
 * @version 1.0
 * @date 2024/3/20 16:34
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("经纬实体类")
public class LocationMessage implements Serializable {

    private static final long serialVersionUID = 8473293468203956320L;

    @ApiModelProperty("纬度")
    private String latitude;

    @ApiModelProperty("经度")
    private String longitude;



}
