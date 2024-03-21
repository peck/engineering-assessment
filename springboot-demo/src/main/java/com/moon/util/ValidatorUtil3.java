package com.moon.util;

import com.moon.constant.Constant;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

/**
 * 描述信息：DTO、List<DTO>数据校验类
 *
 * @author moon
 * @version 1.0
 * @date 2023/2/3 13:06
 */
public class ValidatorUtil3 {

    private static final Validator VALIDATOR;

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        VALIDATOR = factory.getValidator();
    }


    /**
     * 校验单个实体类型
     *
     * @param  obj
     * @param  verfiyGroup
     * @return
     * @author moon  2023/2/8 14:56
     */
    public static String validation(Object obj, Class[] verfiyGroup) {

        Set<ConstraintViolation<Object>> set = null;
        if (verfiyGroup != null) {
            set = VALIDATOR.validate(obj, verfiyGroup);
        } else {
            set = VALIDATOR.validate(obj, new Class[Constant.Digital.ZERO]);
        }

        return set != null && set.size() > 0 ? getValidateErrorMsg(set) : null;
    }


    /**
     * 将实体类中的错误信息拼接后返回。
     *
     * @param set
     * @return
     */
    private static String getValidateErrorMsg(Set<ConstraintViolation<Object>> set) {

        StringBuilder builder = new StringBuilder();

        Iterator var2 = set.iterator();
        while (var2.hasNext()) {
            ConstraintViolation constraintViolation = (ConstraintViolation) var2.next();
            builder.append(constraintViolation.getMessage()).append(Constant.CommonlySymbols.SEMICOLON);
        }

        return builder.toString();
    }

}
