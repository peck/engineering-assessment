package com.moon.controller;

import com.github.pagehelper.PageInfo;
import com.moon.base.BaseResult;
import com.moon.constant.Constant;
import com.moon.pojo.ApplicantMessage;
import com.moon.pojo.User;
import com.moon.service.FoodService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 食物接口
 *
 * @author moon  2022/11/17  16:52
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping(value = "/food")
@Api(tags = {"食物"})
public class FoodController {

    @Autowired
    private FoodService foodService;


    /**
     * 查询食物信息
     *
     * @param name
     *
     * @return
     */
    @GetMapping("/getFood")
    @ApiOperation(value = "查询公司食物信息", notes = "查询食物信息")
    @ApiResponses({
            @ApiResponse(code = Constant.HttpMessage.HTTP_200_CODE, message = Constant.HttpMessage.HTTP_200_MESSAGE, response = BaseResult.class)
    })
    public BaseResult<List<ApplicantMessage>> listUser2(@ApiParam("姓名") @RequestParam(required = false) String name) {
        log.info("查询食物信息，入参姓名为：{}", name);
        // 送餐计划
        List<ApplicantMessage> applicantMessageList = foodService.selectFoodByApplicantName(name);
        return BaseResult.succeed(applicantMessageList);
    }
    

}
