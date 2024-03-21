package com.moon.service;

import com.moon.pojo.ApplicantMessage;

import java.util.List;

/**
 * 描述信息：食物 Service层
 *
 * @author moon
 * @version 1.0
 * @date 2024/3/20 17:44
 */
public interface FoodService {


    /**
     * 根据 公司名 查询食物信息.
     *
     * @param applicantName
     * @return
     */
    List<ApplicantMessage> selectFoodByApplicantName(String applicantName);

}
