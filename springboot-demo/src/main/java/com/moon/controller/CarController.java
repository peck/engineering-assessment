package com.moon.controller;

import com.moon.base.BaseResult;
import com.moon.constant.Constant;
import com.moon.pojo.ApplicantMessage;
import com.moon.service.CarService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 用户信息接口
 *
 * @author moon  2022/11/17  16:52
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping(value = "/car")
@Api(tags = {"卡车"})
public class CarController {

    @Autowired
    private CarService carService;


    /**
     * 查询汽车信息
     *
     * @param cnn
     * @return
     */
    @GetMapping("/getCar")
    @ApiOperation(value = "查询汽车信息", notes = "查询汽车信息")
    @ApiResponses({
            @ApiResponse(code = Constant.HttpMessage.HTTP_200_CODE, message = Constant.HttpMessage.HTTP_200_MESSAGE, response = BaseResult.class)
    })
    public BaseResult<List<ApplicantMessage>> listUser(@ApiParam("编号") @RequestParam Long cnn) {
        log.info("查询汽车信息，编号为：{}", cnn);

        List<ApplicantMessage> targetList = carService.selectCarByCNN(cnn);
        return BaseResult.succeed(targetList);
    }


}
