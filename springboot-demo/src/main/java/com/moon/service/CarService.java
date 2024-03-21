package com.moon.service;

import com.github.pagehelper.PageInfo;
import com.moon.pojo.ApplicantMessage;
import com.moon.pojo.User;

import java.util.List;

/**
 * 描述信息：汽车信息Service
 *
 * @author moon
 * @version 1.0
 * @date 2024/3/20 17:06
 */
public interface CarService {


    /**
     * 根据 编号 查询卡车信息.
     *
     * @param cnn
     * @return
     */
    List<ApplicantMessage> selectCarByCNN(Long cnn);

}
