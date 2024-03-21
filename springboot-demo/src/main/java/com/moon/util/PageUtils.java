package com.moon.util;

import com.github.pagehelper.PageInfo;
import com.moon.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 描述信息：分页处理工具类.
 *
 * @author DY41220
 * @version 1.0
 * @date 2023/5/17 10:34
 */
@Slf4j
public class PageUtils {


    /**
     * 需要对 返回结果 进行手动分页
     *
     * @param objectList 目标集合
     * @param pageInfo   分页类
     * @param pageNum    页码
     * @param pageSize   页尺寸
     * @return
     * @author DY41220  2023/5/17 10:56
     */
    public static <T> PageInfo<T> handlePaging(List<T> objectList, PageInfo pageInfo, Integer pageNum, Integer pageSize) {
        log.info("----------------- 对 返回结果 进行手动分页 开始. -----------------");

        // 设置 总记录数
        if (CollectionUtils.isEmpty(objectList)) {
            pageInfo.setTotal(Constant.Digital.ZERO);
        } else {
            pageInfo.setTotal(objectList.size());
        }

        // 设置 页码
        pageInfo.setPageNum(pageNum);
        // 设置 页面尺寸
        pageInfo.setPageSize(pageSize);

        Integer startNum = (pageNum - 1) * pageSize;  // 起始位置
        Integer endNum = pageNum * pageSize;  // 结束位置

        // 需要对 返回结果 进行手动分页
        if (CollectionUtils.isEmpty(objectList)) {
            pageInfo.setPageNum(Constant.Digital.ONE);  // 设置页码
            pageInfo.setList(new ArrayList<>());
        } else if (objectList.size() < startNum) {
            pageInfo.setPageNum(Constant.Digital.ONE);  // 设置页码
            pageInfo.setList(objectList.subList(Constant.Digital.ZERO, Math.min(pageSize, objectList.size())));
        } else {
            pageInfo.setList(objectList.subList(startNum, Math.min(endNum, objectList.size())));
        }

        log.info("----------------- 对 返回结果 进行手动分页 结束. -----------------");
        return pageInfo;
    }

}
