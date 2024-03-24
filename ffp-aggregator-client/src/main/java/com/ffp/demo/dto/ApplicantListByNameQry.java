package com.ffp.demo.dto;

import com.alibaba.cola.dto.Query;
import lombok.Data;

@Data
public class ApplicantListByNameQry extends Query{
   private String name;
}
