package com.moon.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 描述信息：
 *
 * @author moon
 * @version 1.0
 * @date 2024/3/20 16:28
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("BlockLot实体类")
public class BlockLotMessage implements Serializable {

    private static final long serialVersionUID = 8473293468203956319L;


    @ApiModelProperty("block")
    private String block;

    @ApiModelProperty("lot")
    private String lot;



}
