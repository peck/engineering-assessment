package com.moon.constant;


import javax.validation.GroupSequence;

/**
 * 分组校验
 *
 * @author moon  2023/01/30 09:50
 * @version 1.0
 */
public class ValidGroup {

    /**
     * 查询使用 (配合spring的@Validated功能分组使用)
     */
    public interface Select{};


    /**
     * 新增使用 (配合spring的@Validated功能分组使用)
     */
    public interface Insert{};


    /**
     * 更新使用 (配合spring的@Validated功能分组使用)
     */
    public interface Update{};


    /**
     * 删除使用 (配合spring的@Validated功能分组使用)
     */
    public interface Delete{}


    /**
     * 权限校验使用 (配合spring的@Validated功能分组使用)
     */
    public interface Permission{}


    /**
     * 校验使用 (配合spring的@Validated功能分组使用)
     */
    public interface Check{}


    /**
     * 属性必须有这两个分组的才验证(配合spring的@Validated功能分组使用)
     */
    @GroupSequence({Select.class, Insert.class, Update.class, Delete.class, Permission.class, Check.class})
    public interface All{}

}
