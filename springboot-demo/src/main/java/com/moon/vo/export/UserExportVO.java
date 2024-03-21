package com.moon.vo.export;


import com.alibaba.fastjson2.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@ApiModel("用户实体Excel导出")
public class UserExportVO implements Serializable {

    private static final long serialVersionUID = 8473293468203956317L;

    @ApiModelProperty("用户编号")
    private Long id;

    @ApiModelProperty(value = "是否删除")
    private String isDeleted;

    @ApiModelProperty("用户姓名")
    private String name;

    @ApiModelProperty("用户年龄")
    private Integer age;

    @ApiModelProperty("创建时间")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")  // fastjson中处理时间字段的注解.
    private Date createDate;



    // --------------------------- get/set、构造函数、toString() 函数 ---------------------------


    /**
     * 全参构造函数
     *
     * @param id
     * @param name
     * @param age
     * @param createDate
     */
    public UserExportVO(Long id, String name, Integer age, Date createDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.createDate = createDate;
    }

    /**
     * 无参构造函数
     */
    public UserExportVO() {
        super();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    /**
     * 重写 toString() 函数
     *
     * @return
     */
    @Override
    public String toString() {
        return "UserExportVO{" +
                "id=" + id +
                ", isDeleted='" + isDeleted + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", createDate=" + createDate +
                '}';
    }

}
