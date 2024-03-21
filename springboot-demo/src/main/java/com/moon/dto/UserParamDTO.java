package com.moon.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import com.moon.constant.ValidGroup;
import com.moon.vo.VerifyMode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@ToString
@ApiModel("用户表入参DTO类")
public class UserParamDTO extends VerifyMode implements Serializable {

    private static final long serialVersionUID = 8473293468203956317L;

    @ApiModelProperty(value = "用户编号ID")
    @NotNull(message = "主键ID不能为空！", groups = {ValidGroup.Update.class})
    private Long id;

    @ApiModelProperty(value = "是否删除")
    private String isDeleted;

    @ApiModelProperty(value = "用户姓名")
    @NotBlank(message = "姓名不能为空！", groups = {ValidGroup.Insert.class})
    @Length(message = "姓名最多不能超过{max}个字！", max = 6, groups = {ValidGroup.Insert.class, ValidGroup.Update.class})
    private String name;

    @ApiModelProperty(value = "用户年龄")
    @NotNull(message = "年龄不能为空！", groups = {ValidGroup.Insert.class, ValidGroup.Update.class})
    @Range(message = "年龄最小不低于{min}岁，最大不能超过{max}岁！", min = 0, max = 120, groups = {ValidGroup.Insert.class, ValidGroup.Update.class})
    private Integer age;

    @ApiModelProperty(value = "创建时间")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")  // fastjson中处理时间字段的注解.
    @NotNull(message = "创建时间不能为空！", groups = {ValidGroup.Insert.class})
    private Date createDate;



    // 非数据库表字段

    @ApiModelProperty(value = "用户姓名集合")
    @Size(message = "姓名最少不低于{min}个，最多不超过{max}", min = 0, max = 10, groups = {ValidGroup.Check.class})
    private List<String> nameList;

    @ApiModelProperty(value = "用户姓名(模糊查询)")
    private String nameLike;



    // --------------------------- 自定义函数 ---------------------------



    // --------------------------- 构造函数 ---------------------------

    /**
     * 无参构造函数
     */
    public UserParamDTO() {

    }


}
